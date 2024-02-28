package com.ssinchenko.example.connect;

import java.util.List;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.LongType;
import org.apache.spark.sql.types.StringType;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

/**
 * A simple class that mock the DataFrame logic.
 * It creates a Dataset<Row> from config. It mimic the logic
 * behind a lot of deequ routines.
 */
class DFObject {
    private ConfExample conf;

    public DFObject(ConfExample conf) {
        this.conf = conf;
    }

    public Dataset<Row> createDataFrame(SparkSession spark) {
        var rows = List.of(RowFactory.create(conf.getStrParamter(), conf.getLongParameter()),
                RowFactory.create(conf.getStrParamter(), conf.getLongParameter() + 1));
        var schema = new StructType(new StructField[] { new StructField("colA", new StringType(), false, null),
                new StructField("colB", new LongType(), false, null) });
        return spark.createDataFrame(rows, schema);
    }
}
