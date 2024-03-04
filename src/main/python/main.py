from pyspark.sql.connect.session import SparkSession

from spark_connect_example.app_plugin import JavaLikeObject, create_dataframe_extension

if __name__ == "__main__":
    spark = SparkSession.builder.remote("sc://localhost:15002").getOrCreate()

    df = create_dataframe_extension(spark)
    df.printSchema()
    df.show(10)

    java_like = JavaLikeObject(param_a="some", param_b=100, spark=spark)
    print(java_like._id)
    java_like.set_str_parameter("some")
    java_like.set_long_parameter(1)
    print(java_like.get_long_parameter())
    java_like.set_long_parameter(2)
    print(java_like.get_long_parameter())
    print(java_like.to_string())
