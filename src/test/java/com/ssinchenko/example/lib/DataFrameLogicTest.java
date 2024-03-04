package com.ssinchenko.example.lib;

import org.apache.spark.sql.SparkSession;

import static org.junit.jupiter.api.Assertions.*;

class DataFrameLogicTest {

  @org.junit.jupiter.api.Test
  void createDummyDataFrame() {
    SparkSession.builder().master("local[1]").getOrCreate();
    var df = DataFrameLogic.createDummyDataFrame();
    assertNotEquals(df.columns().length, 0);
  }
}
