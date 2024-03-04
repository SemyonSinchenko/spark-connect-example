// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: example/plugin.proto

// Protobuf Java Version: 3.25.3
package com.ssinchenko.example.proto;

/**
 * Protobuf type {@code example.CallObjectManipulationLogic}
 */
public final class CallObjectManipulationLogic extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:example.CallObjectManipulationLogic)
    CallObjectManipulationLogicOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CallObjectManipulationLogic.newBuilder() to construct.
  private CallObjectManipulationLogic(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CallObjectManipulationLogic() {
    methodName_ = "";
    args_ =
        com.google.protobuf.LazyStringArrayList.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CallObjectManipulationLogic();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.ssinchenko.example.proto.Plugin.internal_static_example_CallObjectManipulationLogic_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.ssinchenko.example.proto.Plugin.internal_static_example_CallObjectManipulationLogic_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.ssinchenko.example.proto.CallObjectManipulationLogic.class, com.ssinchenko.example.proto.CallObjectManipulationLogic.Builder.class);
  }

  public static final int OBJECTID_FIELD_NUMBER = 1;
  private int objectId_ = 0;
  /**
   * <code>int32 objectId = 1 [json_name = "objectId"];</code>
   * @return The objectId.
   */
  @java.lang.Override
  public int getObjectId() {
    return objectId_;
  }

  public static final int NEWOBJECT_FIELD_NUMBER = 2;
  private boolean newObject_ = false;
  /**
   * <code>bool newObject = 2 [json_name = "newObject"];</code>
   * @return The newObject.
   */
  @java.lang.Override
  public boolean getNewObject() {
    return newObject_;
  }

  public static final int DELETEOBJECT_FIELD_NUMBER = 3;
  private boolean deleteObject_ = false;
  /**
   * <code>bool deleteObject = 3 [json_name = "deleteObject"];</code>
   * @return The deleteObject.
   */
  @java.lang.Override
  public boolean getDeleteObject() {
    return deleteObject_;
  }

  public static final int METHODNAME_FIELD_NUMBER = 4;
  @SuppressWarnings("serial")
  private volatile java.lang.Object methodName_ = "";
  /**
   * <code>string methodName = 4 [json_name = "methodName"];</code>
   * @return The methodName.
   */
  @java.lang.Override
  public java.lang.String getMethodName() {
    java.lang.Object ref = methodName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      methodName_ = s;
      return s;
    }
  }
  /**
   * <code>string methodName = 4 [json_name = "methodName"];</code>
   * @return The bytes for methodName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getMethodNameBytes() {
    java.lang.Object ref = methodName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      methodName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ARGS_FIELD_NUMBER = 5;
  @SuppressWarnings("serial")
  private com.google.protobuf.LazyStringArrayList args_ =
      com.google.protobuf.LazyStringArrayList.emptyList();
  /**
   * <code>repeated string args = 5 [json_name = "args"];</code>
   * @return A list containing the args.
   */
  public com.google.protobuf.ProtocolStringList
      getArgsList() {
    return args_;
  }
  /**
   * <code>repeated string args = 5 [json_name = "args"];</code>
   * @return The count of args.
   */
  public int getArgsCount() {
    return args_.size();
  }
  /**
   * <code>repeated string args = 5 [json_name = "args"];</code>
   * @param index The index of the element to return.
   * @return The args at the given index.
   */
  public java.lang.String getArgs(int index) {
    return args_.get(index);
  }
  /**
   * <code>repeated string args = 5 [json_name = "args"];</code>
   * @param index The index of the value to return.
   * @return The bytes of the args at the given index.
   */
  public com.google.protobuf.ByteString
      getArgsBytes(int index) {
    return args_.getByteString(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (objectId_ != 0) {
      output.writeInt32(1, objectId_);
    }
    if (newObject_ != false) {
      output.writeBool(2, newObject_);
    }
    if (deleteObject_ != false) {
      output.writeBool(3, deleteObject_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(methodName_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, methodName_);
    }
    for (int i = 0; i < args_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, args_.getRaw(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (objectId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, objectId_);
    }
    if (newObject_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, newObject_);
    }
    if (deleteObject_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, deleteObject_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(methodName_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, methodName_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < args_.size(); i++) {
        dataSize += computeStringSizeNoTag(args_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getArgsList().size();
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.ssinchenko.example.proto.CallObjectManipulationLogic)) {
      return super.equals(obj);
    }
    com.ssinchenko.example.proto.CallObjectManipulationLogic other = (com.ssinchenko.example.proto.CallObjectManipulationLogic) obj;

    if (getObjectId()
        != other.getObjectId()) return false;
    if (getNewObject()
        != other.getNewObject()) return false;
    if (getDeleteObject()
        != other.getDeleteObject()) return false;
    if (!getMethodName()
        .equals(other.getMethodName())) return false;
    if (!getArgsList()
        .equals(other.getArgsList())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + OBJECTID_FIELD_NUMBER;
    hash = (53 * hash) + getObjectId();
    hash = (37 * hash) + NEWOBJECT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getNewObject());
    hash = (37 * hash) + DELETEOBJECT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getDeleteObject());
    hash = (37 * hash) + METHODNAME_FIELD_NUMBER;
    hash = (53 * hash) + getMethodName().hashCode();
    if (getArgsCount() > 0) {
      hash = (37 * hash) + ARGS_FIELD_NUMBER;
      hash = (53 * hash) + getArgsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.ssinchenko.example.proto.CallObjectManipulationLogic parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ssinchenko.example.proto.CallObjectManipulationLogic parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ssinchenko.example.proto.CallObjectManipulationLogic parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ssinchenko.example.proto.CallObjectManipulationLogic parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ssinchenko.example.proto.CallObjectManipulationLogic parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ssinchenko.example.proto.CallObjectManipulationLogic parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ssinchenko.example.proto.CallObjectManipulationLogic parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ssinchenko.example.proto.CallObjectManipulationLogic parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.ssinchenko.example.proto.CallObjectManipulationLogic parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.ssinchenko.example.proto.CallObjectManipulationLogic parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ssinchenko.example.proto.CallObjectManipulationLogic parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ssinchenko.example.proto.CallObjectManipulationLogic parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.ssinchenko.example.proto.CallObjectManipulationLogic prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code example.CallObjectManipulationLogic}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:example.CallObjectManipulationLogic)
      com.ssinchenko.example.proto.CallObjectManipulationLogicOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ssinchenko.example.proto.Plugin.internal_static_example_CallObjectManipulationLogic_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ssinchenko.example.proto.Plugin.internal_static_example_CallObjectManipulationLogic_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ssinchenko.example.proto.CallObjectManipulationLogic.class, com.ssinchenko.example.proto.CallObjectManipulationLogic.Builder.class);
    }

    // Construct using com.ssinchenko.example.proto.CallObjectManipulationLogic.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      objectId_ = 0;
      newObject_ = false;
      deleteObject_ = false;
      methodName_ = "";
      args_ =
          com.google.protobuf.LazyStringArrayList.emptyList();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.ssinchenko.example.proto.Plugin.internal_static_example_CallObjectManipulationLogic_descriptor;
    }

    @java.lang.Override
    public com.ssinchenko.example.proto.CallObjectManipulationLogic getDefaultInstanceForType() {
      return com.ssinchenko.example.proto.CallObjectManipulationLogic.getDefaultInstance();
    }

    @java.lang.Override
    public com.ssinchenko.example.proto.CallObjectManipulationLogic build() {
      com.ssinchenko.example.proto.CallObjectManipulationLogic result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.ssinchenko.example.proto.CallObjectManipulationLogic buildPartial() {
      com.ssinchenko.example.proto.CallObjectManipulationLogic result = new com.ssinchenko.example.proto.CallObjectManipulationLogic(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.ssinchenko.example.proto.CallObjectManipulationLogic result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.objectId_ = objectId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.newObject_ = newObject_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.deleteObject_ = deleteObject_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.methodName_ = methodName_;
      }
      if (((from_bitField0_ & 0x00000010) != 0)) {
        args_.makeImmutable();
        result.args_ = args_;
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.ssinchenko.example.proto.CallObjectManipulationLogic) {
        return mergeFrom((com.ssinchenko.example.proto.CallObjectManipulationLogic)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.ssinchenko.example.proto.CallObjectManipulationLogic other) {
      if (other == com.ssinchenko.example.proto.CallObjectManipulationLogic.getDefaultInstance()) return this;
      if (other.getObjectId() != 0) {
        setObjectId(other.getObjectId());
      }
      if (other.getNewObject() != false) {
        setNewObject(other.getNewObject());
      }
      if (other.getDeleteObject() != false) {
        setDeleteObject(other.getDeleteObject());
      }
      if (!other.getMethodName().isEmpty()) {
        methodName_ = other.methodName_;
        bitField0_ |= 0x00000008;
        onChanged();
      }
      if (!other.args_.isEmpty()) {
        if (args_.isEmpty()) {
          args_ = other.args_;
          bitField0_ |= 0x00000010;
        } else {
          ensureArgsIsMutable();
          args_.addAll(other.args_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              objectId_ = input.readInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 16: {
              newObject_ = input.readBool();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 24: {
              deleteObject_ = input.readBool();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
            case 34: {
              methodName_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000008;
              break;
            } // case 34
            case 42: {
              java.lang.String s = input.readStringRequireUtf8();
              ensureArgsIsMutable();
              args_.add(s);
              break;
            } // case 42
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private int objectId_ ;
    /**
     * <code>int32 objectId = 1 [json_name = "objectId"];</code>
     * @return The objectId.
     */
    @java.lang.Override
    public int getObjectId() {
      return objectId_;
    }
    /**
     * <code>int32 objectId = 1 [json_name = "objectId"];</code>
     * @param value The objectId to set.
     * @return This builder for chaining.
     */
    public Builder setObjectId(int value) {

      objectId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int32 objectId = 1 [json_name = "objectId"];</code>
     * @return This builder for chaining.
     */
    public Builder clearObjectId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      objectId_ = 0;
      onChanged();
      return this;
    }

    private boolean newObject_ ;
    /**
     * <code>bool newObject = 2 [json_name = "newObject"];</code>
     * @return The newObject.
     */
    @java.lang.Override
    public boolean getNewObject() {
      return newObject_;
    }
    /**
     * <code>bool newObject = 2 [json_name = "newObject"];</code>
     * @param value The newObject to set.
     * @return This builder for chaining.
     */
    public Builder setNewObject(boolean value) {

      newObject_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>bool newObject = 2 [json_name = "newObject"];</code>
     * @return This builder for chaining.
     */
    public Builder clearNewObject() {
      bitField0_ = (bitField0_ & ~0x00000002);
      newObject_ = false;
      onChanged();
      return this;
    }

    private boolean deleteObject_ ;
    /**
     * <code>bool deleteObject = 3 [json_name = "deleteObject"];</code>
     * @return The deleteObject.
     */
    @java.lang.Override
    public boolean getDeleteObject() {
      return deleteObject_;
    }
    /**
     * <code>bool deleteObject = 3 [json_name = "deleteObject"];</code>
     * @param value The deleteObject to set.
     * @return This builder for chaining.
     */
    public Builder setDeleteObject(boolean value) {

      deleteObject_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>bool deleteObject = 3 [json_name = "deleteObject"];</code>
     * @return This builder for chaining.
     */
    public Builder clearDeleteObject() {
      bitField0_ = (bitField0_ & ~0x00000004);
      deleteObject_ = false;
      onChanged();
      return this;
    }

    private java.lang.Object methodName_ = "";
    /**
     * <code>string methodName = 4 [json_name = "methodName"];</code>
     * @return The methodName.
     */
    public java.lang.String getMethodName() {
      java.lang.Object ref = methodName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        methodName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string methodName = 4 [json_name = "methodName"];</code>
     * @return The bytes for methodName.
     */
    public com.google.protobuf.ByteString
        getMethodNameBytes() {
      java.lang.Object ref = methodName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        methodName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string methodName = 4 [json_name = "methodName"];</code>
     * @param value The methodName to set.
     * @return This builder for chaining.
     */
    public Builder setMethodName(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      methodName_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>string methodName = 4 [json_name = "methodName"];</code>
     * @return This builder for chaining.
     */
    public Builder clearMethodName() {
      methodName_ = getDefaultInstance().getMethodName();
      bitField0_ = (bitField0_ & ~0x00000008);
      onChanged();
      return this;
    }
    /**
     * <code>string methodName = 4 [json_name = "methodName"];</code>
     * @param value The bytes for methodName to set.
     * @return This builder for chaining.
     */
    public Builder setMethodNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      methodName_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringArrayList args_ =
        com.google.protobuf.LazyStringArrayList.emptyList();
    private void ensureArgsIsMutable() {
      if (!args_.isModifiable()) {
        args_ = new com.google.protobuf.LazyStringArrayList(args_);
      }
      bitField0_ |= 0x00000010;
    }
    /**
     * <code>repeated string args = 5 [json_name = "args"];</code>
     * @return A list containing the args.
     */
    public com.google.protobuf.ProtocolStringList
        getArgsList() {
      args_.makeImmutable();
      return args_;
    }
    /**
     * <code>repeated string args = 5 [json_name = "args"];</code>
     * @return The count of args.
     */
    public int getArgsCount() {
      return args_.size();
    }
    /**
     * <code>repeated string args = 5 [json_name = "args"];</code>
     * @param index The index of the element to return.
     * @return The args at the given index.
     */
    public java.lang.String getArgs(int index) {
      return args_.get(index);
    }
    /**
     * <code>repeated string args = 5 [json_name = "args"];</code>
     * @param index The index of the value to return.
     * @return The bytes of the args at the given index.
     */
    public com.google.protobuf.ByteString
        getArgsBytes(int index) {
      return args_.getByteString(index);
    }
    /**
     * <code>repeated string args = 5 [json_name = "args"];</code>
     * @param index The index to set the value at.
     * @param value The args to set.
     * @return This builder for chaining.
     */
    public Builder setArgs(
        int index, java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      ensureArgsIsMutable();
      args_.set(index, value);
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }
    /**
     * <code>repeated string args = 5 [json_name = "args"];</code>
     * @param value The args to add.
     * @return This builder for chaining.
     */
    public Builder addArgs(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      ensureArgsIsMutable();
      args_.add(value);
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }
    /**
     * <code>repeated string args = 5 [json_name = "args"];</code>
     * @param values The args to add.
     * @return This builder for chaining.
     */
    public Builder addAllArgs(
        java.lang.Iterable<java.lang.String> values) {
      ensureArgsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, args_);
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }
    /**
     * <code>repeated string args = 5 [json_name = "args"];</code>
     * @return This builder for chaining.
     */
    public Builder clearArgs() {
      args_ =
        com.google.protobuf.LazyStringArrayList.emptyList();
      bitField0_ = (bitField0_ & ~0x00000010);;
      onChanged();
      return this;
    }
    /**
     * <code>repeated string args = 5 [json_name = "args"];</code>
     * @param value The bytes of the args to add.
     * @return This builder for chaining.
     */
    public Builder addArgsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      ensureArgsIsMutable();
      args_.add(value);
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:example.CallObjectManipulationLogic)
  }

  // @@protoc_insertion_point(class_scope:example.CallObjectManipulationLogic)
  private static final com.ssinchenko.example.proto.CallObjectManipulationLogic DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.ssinchenko.example.proto.CallObjectManipulationLogic();
  }

  public static com.ssinchenko.example.proto.CallObjectManipulationLogic getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CallObjectManipulationLogic>
      PARSER = new com.google.protobuf.AbstractParser<CallObjectManipulationLogic>() {
    @java.lang.Override
    public CallObjectManipulationLogic parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<CallObjectManipulationLogic> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CallObjectManipulationLogic> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.ssinchenko.example.proto.CallObjectManipulationLogic getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
