// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: match.proto

package io.grpc.examples.match;

public interface QueryRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:match.QueryRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated string sentences = 1;</code>
   */
  java.util.List<java.lang.String>
      getSentencesList();
  /**
   * <code>repeated string sentences = 1;</code>
   */
  int getSentencesCount();
  /**
   * <code>repeated string sentences = 1;</code>
   */
  java.lang.String getSentences(int index);
  /**
   * <code>repeated string sentences = 1;</code>
   */
  com.google.protobuf.ByteString
      getSentencesBytes(int index);

  /**
   * <code>optional string query = 2;</code>
   */
  java.lang.String getQuery();
  /**
   * <code>optional string query = 2;</code>
   */
  com.google.protobuf.ByteString
      getQueryBytes();
}
