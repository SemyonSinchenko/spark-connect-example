from __future__ import annotations

from typing import TYPE_CHECKING

from pyspark.sql.connect import proto
from pyspark.sql.connect.dataframe import DataFrame
from pyspark.sql.connect.plan import LogicalPlan

from spark_connect_example.proto.plugin_pb2 import CallCommandLikeLogic, CallDataFrameLogic, CallObjectManipulationLogic

if TYPE_CHECKING:
    from pyspark.sql.connect.client import SparkConnectClient
    from pyspark.sql.connect.session import SparkSession


class CallCommandPlan(LogicalPlan):
    def __init__(self, param_a: int, param_b: int, param_c: str) -> None:
        super().__init__(None)
        self._a = param_a
        self._b = param_b
        self._c = param_c

    def command(self, session: SparkConnectClient) -> proto.Command:
        command = proto.Command()
        command.extension.Pack(CallCommandLikeLogic(paramA=self._a, paramB=self._b, paramC=self._c))
        return command


def call_command(a: int, b: int, file_name: str, spark: SparkSession) -> None:
    print(file_name)
    DataFrame(CallCommandPlan(a, b, file_name), spark).collect()


class CallDataFrameLogicPlan(LogicalPlan):
    def __init__(self) -> None:
        super().__init__(None)

    def plan(self, session: SparkConnectClient) -> proto.Relation:
        plan = self._create_proto_relation()
        ext = CallDataFrameLogic()
        plan.extension.Pack(ext)
        return plan


def create_dataframe_extension(spark: SparkSession) -> DataFrame:
    return DataFrame(CallDataFrameLogicPlan(), spark)


class CallObjectManipulationPlan(LogicalPlan):
    def __init__(
        self,
        object_id: int = 0,
        new_object: bool = False,
        delete_object: bool = False,
        method_name: str = "",
        jargs: list[str] | None = None,
    ) -> None:
        if jargs is None:
            jargs = []
        super().__init__(None)
        self._object_id = object_id
        self._new_object = new_object
        self._delete_object = delete_object
        self._method_name = method_name
        self._jargs = jargs

    def plan(self, session: SparkConnectClient) -> proto.Relation:
        plan = self._create_proto_relation()
        ext = CallObjectManipulationLogic(
            objectId=self._object_id,
            newObject=self._new_object,
            deleteObject=self._delete_object,
            methodName=self._method_name,
            args=self._jargs,
        )
        plan.extension.Pack(ext)

        return plan


class JavaLikeObject:
    def __init__(self, param_a: str, param_b: int, spark: SparkSession) -> None:
        query_plan = CallObjectManipulationPlan(new_object=True, jargs=[param_a, str(param_b)])
        df = DataFrame(query_plan, spark)
        if "errorMessage" in df.columns:
            err_msg = df.collect()[0].asDict().get("errorMessage", "")
            raise ValueError(err_msg)
        obj_id = df.collect()[0].asDict().get("id", -1)
        self._id = obj_id
        self._spark = spark

    def get_str_parameter(self) -> str:
        query_plan = CallObjectManipulationPlan(object_id=self._id, method_name="getStrParameter")
        return DataFrame(query_plan, self._spark).collect()[0].asDict().get("strParameter", "")

    def get_long_parameter(self) -> int:
        query_plan = CallObjectManipulationPlan(object_id=self._id, method_name="getLongParameter")
        return DataFrame(query_plan, self._spark).collect()[0].asDict().get("longParameter", -1)

    def set_str_parameter(self, str_par: str) -> None:
        query_plan = CallObjectManipulationPlan(object_id=self._id, method_name="setStrParameter", jargs=[str_par])
        DataFrame(query_plan, self._spark).collect()

    def set_long_parameter(self, long_par: int) -> None:
        query_plan = CallObjectManipulationPlan(object_id=self._id, method_name="setLongParameter", jargs=[str(long_par)])
        DataFrame(query_plan, self._spark).collect()

    def to_string(self) -> str:
        query_plan = CallObjectManipulationPlan(object_id=self._id, method_name="toString")
        return DataFrame(query_plan, self._spark).collect()[0].asDict().get("stringRepresentation", "")

    def delete(self) -> None:
        query_plan = CallObjectManipulationPlan(object_id=self._id, delete_object=True)
        DataFrame(query_plan, self._spark)
