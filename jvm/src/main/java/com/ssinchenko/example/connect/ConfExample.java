package com.ssinchenko.example.connect;

import org.apache.hadoop.fs.Path;
import org.apache.spark.sql.SparkSession;

import java.io.IOException;

/**
 * A simple Java class that represents configuration of the job.
 * It should initialized by reading from the storage with
 * org.apache.hadoop.fs.FileSystem.
 * Also there should be an option to modify an object from users code.
 * 
 * Such a class should represent an example of deequ MetricsRepository or
 * GraphAr Info* objects.
 */
public class ConfExample {
    private String strParamter;
    private Long longParameter;

    private ConfExample(String strParameter, Long longParameter) {
        this.strParamter = strParameter;
        this.longParameter = longParameter;
    }

    public static ConfExample fromTXT(String stringPath, SparkSession session) throws IOException {
        var path = new Path(stringPath);
        var fs = path.getFileSystem(session.sparkContext().hadoopConfiguration());
        var stream = fs.open(path);

        var strings = stream.readUTF().split("\n");
        return new ConfExample(strings[0], Long.parseLong(strings[1]));
    }

    public String getStrParamter() {
        return strParamter;
    }

    public void setStrParamter(String strParamter) {
        this.strParamter = strParamter;
    }

    public Long getLongParameter() {
        return longParameter;
    }

    public void setLongParameter(Long longParameter) {
        this.longParameter = longParameter;
    }
}
