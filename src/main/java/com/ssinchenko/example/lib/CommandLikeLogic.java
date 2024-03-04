package com.ssinchenko.example.lib;

import org.apache.hadoop.fs.Path;
import org.apache.spark.sql.SparkSession;

import java.io.IOException;

/**
 * This class is a very simple tool that represents calling a command. Like when we need just to do
 * something on the side of JVM. An example use-case is when we need to log something.
 */
public class CommandLikeLogic {
  /**
   * A dummy static method that takes three parameters and create a file with two of them.
   *
   * @param paramA a first parameter
   * @param paramB a second parameter
   * @param paramC a name of the file
   * @throws IOException in the case of IO-problems with HadoopFs
   */
  public static void commandA(Long paramA, Long paramB, String paramC) throws IOException {
    var spark = SparkSession.active().sharedState();
    var path = new Path(paramC);
    var fs = path.getFileSystem(spark.hadoopConf());
    var outputStream = fs.create(path);
    outputStream.writeUTF(String.format("FieldA: %d\nFieldB: %d", paramA, paramB));
    outputStream.flush();
    outputStream.close();
  }
}
