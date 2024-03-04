// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: example/plugin.proto

// Protobuf Java Version: 3.25.3
package com.ssinchenko.example.proto;

public interface CallObjectManipulationLogicOrBuilder extends
    // @@protoc_insertion_point(interface_extends:example.CallObjectManipulationLogic)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 objectId = 1 [json_name = "objectId"];</code>
   * @return The objectId.
   */
  int getObjectId();

  /**
   * <code>bool newObject = 2 [json_name = "newObject"];</code>
   * @return The newObject.
   */
  boolean getNewObject();

  /**
   * <code>bool deleteObject = 3 [json_name = "deleteObject"];</code>
   * @return The deleteObject.
   */
  boolean getDeleteObject();

  /**
   * <code>string methodName = 4 [json_name = "methodName"];</code>
   * @return The methodName.
   */
  java.lang.String getMethodName();
  /**
   * <code>string methodName = 4 [json_name = "methodName"];</code>
   * @return The bytes for methodName.
   */
  com.google.protobuf.ByteString
      getMethodNameBytes();

  /**
   * <code>repeated string args = 5 [json_name = "args"];</code>
   * @return A list containing the args.
   */
  java.util.List<java.lang.String>
      getArgsList();
  /**
   * <code>repeated string args = 5 [json_name = "args"];</code>
   * @return The count of args.
   */
  int getArgsCount();
  /**
   * <code>repeated string args = 5 [json_name = "args"];</code>
   * @param index The index of the element to return.
   * @return The args at the given index.
   */
  java.lang.String getArgs(int index);
  /**
   * <code>repeated string args = 5 [json_name = "args"];</code>
   * @param index The index of the value to return.
   * @return The bytes of the args at the given index.
   */
  com.google.protobuf.ByteString
      getArgsBytes(int index);
}
