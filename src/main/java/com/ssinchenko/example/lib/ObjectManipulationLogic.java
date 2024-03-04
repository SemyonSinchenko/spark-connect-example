package com.ssinchenko.example.lib;

import java.io.IOException;
import org.apache.hadoop.fs.Path;
import org.apache.spark.sql.SparkSession;

/**
 * This class represents the case when we want to create regular classes and objects on the JVM side.
 * An example use-case is when we create this Object from config file and use getters/setters to manipulate.
 */
public class ObjectManipulationLogic {
    private String strParameter;
    private Long longParameter;

    private ObjectManipulationLogic(String strParameter, Long longParameter) {
        this.strParameter = strParameter;
        this.longParameter = longParameter;
    }

    public static ObjectManipulationLogic fromTXT(String stringPath, SparkSession session) throws IOException {
        var path = new Path(stringPath);
        var fs = path.getFileSystem(session.sparkContext().hadoopConfiguration());
        var stream = fs.open(path);

        var strings = stream.readUTF().split("\n");
        return new ObjectManipulationLogic(strings[0], Long.parseLong(strings[1]));
    }

    public String getStrParameter() {
        return strParameter;
    }

    public void setStrParameter(String strParameter) {
        this.strParameter = strParameter;
    }

    public Long getLongParameter() {
        return longParameter;
    }

    public void setLongParameter(Long longParameter) {
        this.longParameter = longParameter;
    }

    @Override
    public String toString() {
        return "ObjectManipulationLogic{" +
                "strParameter='" + strParameter + '\'' +
                ", longParameter=" + longParameter +
                '}';
    }
}
