package com.ssinchenko.example.server;

import org.apache.spark.sql.connect.planner.SparkConnectPlanner;
import org.apache.spark.sql.connect.plugin.CommandPlugin;
import org.sparkproject.connect.protobuf.Any;

import scala.Option;
import scala.runtime.BoxedUnit;

class ObjectExtensionPlugin implements CommandPlugin {

    @Override
    public Option<BoxedUnit> process(Any command, SparkConnectPlanner planner) {
        // I have zero ideas what to do here... Even from what should I start.
        // for examlple, if I want to create on JVM-side an instance of ConfExample,
        // that is defined in connect package.
        // What should I do here?
        // What the hell is this Option<BoxedUnit>??
        // How Any command will look in runtime?
        // I need at least a single advice or an example.
        return Option.empty();
    }

}
