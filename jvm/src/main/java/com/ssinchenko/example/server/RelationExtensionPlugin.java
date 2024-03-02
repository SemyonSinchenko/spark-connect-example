package com.ssinchenko.example.server;

import com.google.protobuf.Any;
import com.ssinchenko.example.connect.ConfExample;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan;
import org.apache.spark.sql.connect.planner.SparkConnectPlanner;
import org.apache.spark.sql.connect.plugin.RelationPlugin;
import scala.Option;

import com.ssinchenko.example.connect.DFObject;
import com.ssinchenko.example.proto.CallDFObjectCreateDataFrame;

import java.io.IOException;

class RelationExtensionPlugin implements RelationPlugin {
    @Override
    public Option<LogicalPlan> transform(Any relation, SparkConnectPlanner planner) {
        if (!relation.is(CallDFObjectCreateDataFrame.class)) {
            return Option.empty();
        } else {
            try {
                var command = relation.unpack(CallDFObjectCreateDataFrame.class);
                var conf = ConfExample.fromTXT(command.getStringPath(), SparkSession.builder().getOrCreate());
                var dfObject = new DFObject(conf);

                return Option.apply(
                        dfObject
                                .createDataFrame(SparkSession.builder().getOrCreate())
                                .logicalPlan()
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
