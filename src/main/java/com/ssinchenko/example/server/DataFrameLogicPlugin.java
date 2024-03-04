package com.ssinchenko.example.server;

import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.ssinchenko.example.lib.DataFrameLogic;
import com.ssinchenko.example.proto.CallDataFrameLogic;
import java.util.Optional;
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan;
import org.apache.spark.sql.connect.planner.SparkConnectPlanner;
import org.apache.spark.sql.connect.plugin.RelationPlugin;

/**
 * The "right" way to use RelationPlugin. Just parse an input and return a "real" DataFrame. Nothing
 * special.
 */
public class DataFrameLogicPlugin implements RelationPlugin {
  @Override
  public Optional<LogicalPlan> transform(byte[] relation, SparkConnectPlanner planner) {
    Any relationProto;
    try {
      relationProto = Any.parseFrom(relation);
    } catch (InvalidProtocolBufferException e) {
      throw new RuntimeException(e);
    }
    if (relationProto.is(CallDataFrameLogic.class)) {
      return Optional.of(DataFrameLogic.createDummyDataFrame().logicalPlan());
    }
    return Optional.empty();
  }
}
