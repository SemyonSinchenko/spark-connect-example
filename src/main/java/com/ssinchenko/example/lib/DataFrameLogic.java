package com.ssinchenko.example.lib;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.util.ArrayList;
import java.util.Random;

/** A dummy class that represents any DataFrame logic. The simplest case from all cases. */
public class DataFrameLogic {
  public static Dataset<Row> createDummyDataFrame() {
    var schema =
        new StructType(
            new StructField[] {
              DataTypes.createStructField("col1", DataTypes.LongType, true),
              DataTypes.createStructField("col2", DataTypes.StringType, true),
              DataTypes.createStructField("col3", DataTypes.BooleanType, true)
            });
    var spark = SparkSession.active();
    var rows = new ArrayList<Row>();
    var gen = new Random();
    for (int i = 0; i <= 10; i++) {
      rows.add(
          RowFactory.create(
              gen.nextLong(),
              String.format("%d-%d", gen.nextInt(), gen.nextLong()),
              gen.nextBoolean()));
    }
    return spark.createDataFrame(rows, schema);
  }
}
