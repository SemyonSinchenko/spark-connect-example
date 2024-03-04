from pathlib import Path

from pyspark.sql.connect.session import SparkSession

from spark_connect_example.app_plugin import JavaLikeObject, call_command, create_dataframe_extension

if __name__ == "__main__":
    spark = SparkSession.builder.remote("sc://localhost:15002").getOrCreate()
    temp_conf_file = Path("txt.config")
    with temp_conf_file.open(mode="w", encoding="utf-16") as tmp_file:
        tmp_file.writelines(["paramA", "\n", "100"])

    java_like = JavaLikeObject(config_file=temp_conf_file.absolute().__str__(), spark=spark)
    java_like.set_str_parameter("some")
    java_like.set_long_parameter(1)
    print(java_like.get_long_parameter())
    java_like.set_long_parameter(2)
    print(java_like.get_long_parameter())
    print(java_like.to_string())

    temp_conf_file.unlink()

    create_dataframe_extension(spark).show(10)

    call_command(1, 2, "another_test_file", spark)

    with Path("another_test_file").open("r", encoding="utf-16") as tmp_file:
        context = tmp_file.readlines()

        for line in context:
            print(line)

    Path("another_text_file").unlink()
