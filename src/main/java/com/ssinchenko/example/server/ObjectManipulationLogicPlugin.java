package com.ssinchenko.example.server;

import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.ssinchenko.example.lib.ObjectManipulationLogic;
import com.ssinchenko.example.proto.CallObjectManipulationLogic;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan;
import org.apache.spark.sql.connect.planner.SparkConnectPlanner;
import org.apache.spark.sql.connect.plugin.RelationPlugin;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class ObjectManipulationLogicPlugin implements RelationPlugin {
  /**
   * This is a map, that stores link to all the objects.
   */
  private static final HashMap<Integer, ObjectManipulationLogic> idsMapping =
      new HashMap<>(Integer.MAX_VALUE);

  public static ObjectManipulationLogic getObj(Integer id) {
    return idsMapping.get(id);
  }

  public static Integer addObj(ObjectManipulationLogic obj) {
    var id = System.identityHashCode(obj);
    idsMapping.put(id, obj);
    return id;
  }

  public static void dropObj(Integer id) {
    idsMapping.remove(id);
  }

  @Override
  public Optional<LogicalPlan> transform(byte[] relation, SparkConnectPlanner planner) {
    // To make the code simpler I'm not checking type of passed from Python arguments!
    // So, the overall logic is build on the assumption, that it is impossible to get
    // from python an invalid string or invalid long.
    //
    // It makes sense, because it is x10 simpler to do it on the Python side
      Any relationProto = null;
      try {
          relationProto = Any.parseFrom(relation);
      } catch (InvalidProtocolBufferException e) {
          return Optional.empty();
      }
      if (relationProto.is(CallObjectManipulationLogic.class)) {
      var spark = planner.sessionHolder().session();
      try {
        // We are parsing the message
        var message = relationProto.unpack(CallObjectManipulationLogic.class);
        if (message.getNewObject()) {
          // If we need to create a new object we are doing the following:
          // 1. Get args
          // 2. Create an instance
          // 3. Add an id of the instance to the Map
          // 4. Return the id to Python
          var args = message.getArgsList();
          var stringPath = args.get(0);
          var instance = ObjectManipulationLogic.fromTXT(stringPath, spark);
          var id = ObjectManipulationLogicPlugin.addObj(instance);
          var df =
              spark.createDataFrame(
                  List.of(RowFactory.create(id)),
                  new StructType(
                      new StructField[] {
                        new StructField("id", DataTypes.IntegerType, false, null)
                      }));
          return Optional.of(df.logicalPlan());
        } else if (message.getDeleteObject()) {
          // If we need to drop the object we just delete it from the Map
          // After that GC will do it's work.
          var id = message.getObjectId();
          ObjectManipulationLogicPlugin.dropObj(id);
          return Optional.empty();
        } else {
          // All other cases is when we need to call a method
          var methodName = message.getMethodName();
          var args = message.getArgsList();
          var id = message.getObjectId();

          var instance = ObjectManipulationLogicPlugin.getObj(id);

          // Possible to do the same via Reflection API;
          // But to achieve explicitly I'm directly check the method name.
          // We need to know types anyway, to return a DataFrame with a right schema.

          // So, we are checking all the possible methods and do the following:
          // 1. If it is setter than just parse args and modify the obj
          // 2. If it is getter or toString we just wrap the output into DataFrame
          switch (methodName) {
            case "getStrParameter" -> {
              var df =
                  spark.createDataFrame(
                      List.of(RowFactory.create(instance.getStrParameter())),
                      new StructType(
                          new StructField[] {
                            new StructField("strParameter", DataTypes.StringType, false, null)
                          }));
              return Optional.of(df.logicalPlan());
            }
            case "getLongParameter" -> {
              var df =
                  spark.createDataFrame(
                      List.of(RowFactory.create(instance.getLongParameter())),
                      new StructType(
                          new StructField[] {
                            new StructField("longParameter", DataTypes.LongType, false, null)
                          }));
              return Optional.of(df.logicalPlan());
            }
            case "setStrParameter" -> {
              instance.setStrParameter(args.get(0));
              return Optional.empty();
            }
            case "setLongParameter" -> {
              instance.setLongParameter(Long.parseLong(args.get(0)));
              return Optional.empty();
            }
            case "toString" -> {
              var df =
                  spark.createDataFrame(
                      List.of(RowFactory.create(instance.toString())),
                      new StructType(
                          new StructField[] {
                            new StructField(
                                "stringRepresentation", DataTypes.StringType, false, null)
                          }));
              return Optional.of(df.logicalPlan());
            }
            default -> {
              var df =
                  spark.createDataFrame(
                      List.of(
                          RowFactory.create(String.format("Invalid method name %s", methodName))),
                      new StructType(
                          new StructField[] {
                            new StructField("errorMessage", DataTypes.StringType, false, null)
                          }));
              return Optional.of(df.logicalPlan());
            }
          }
        }
      } catch (IOException e) {
        // In the case of error we are just wrapping the error message to DataFrame
        var df =
            spark.createDataFrame(
                List.of(RowFactory.create(String.format("IOException %s", e.getMessage()))),
                new StructType(
                    new StructField[] {
                      new StructField("errorMessage", DataTypes.StringType, false, null)
                    }));
        return Optional.of(df.logicalPlan());
      }
    }

    return Optional.empty();
  }
}
