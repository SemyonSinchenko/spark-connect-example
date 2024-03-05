# An example of extending SparkConnect Protocol
[Link to the blog post](https://semyonsinchenko.github.io/ssinchenko/post/extending-spark-connect/)

## Introduction

This project is written to work with a fresh (March, 2024) version of Apache Spark: 4.0.0-SNAPSHOT. There are a lot of reasons for it, it is detailed described inside a blog-post. It is hardly recommended to follow the blog-post text.

## Experiment desing

This repository and the corresponding blog-post is trying to cover the topic of migration of PySpark extensions based on `py4j` to a "new spark" with decoupled architecture. Inside the code there is an answer to the question how to interact with JVM classes and objects from Python via SparkConnect protocol.

## Structure

There are four main parts:

1. A JVM library we are trying to call from PySpark via gRPC: [link](https://github.com/SemyonSinchenko/spark-connect-example/tree/master/src/main/java/com/ssinchenko/example/lib);
2. A server-side plugins for SparkConnect written in Java: [linl](https://github.com/SemyonSinchenko/spark-connect-example/tree/master/src/main/java/com/ssinchenko/example/server);
3. A protobuf messages definition: [link](https://github.com/SemyonSinchenko/spark-connect-example/tree/master/src/main/protobuf)
4. A PySpark client part: [link](https://github.com/SemyonSinchenko/spark-connect-example/tree/master/src/main/python)

## Future plans

I will try to improve this `README.md` file, also I'm going to clean the code a little.
