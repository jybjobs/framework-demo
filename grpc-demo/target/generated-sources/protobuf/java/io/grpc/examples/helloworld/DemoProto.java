// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: demo.proto

package io.grpc.examples.helloworld;

public final class DemoProto {
  private DemoProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_DemoRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_DemoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_DemoReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_DemoReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\ndemo.proto\022\nhelloworld\"\033\n\013DemoRequest\022" +
      "\014\n\004name\030\001 \001(\t\"\034\n\tDemoReply\022\017\n\007message\030\001 " +
      "\001(\t2J\n\013DemoService\022;\n\007getInfo\022\027.hellowor" +
      "ld.DemoRequest\032\025.helloworld.DemoReply\"\000B" +
      "1\n\033io.grpc.examples.helloworldB\tDemoProt" +
      "oP\001\242\002\004DEMOb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_helloworld_DemoRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_helloworld_DemoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_DemoRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_helloworld_DemoReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_helloworld_DemoReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_DemoReply_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
