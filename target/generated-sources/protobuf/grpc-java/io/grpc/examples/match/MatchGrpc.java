package io.grpc.examples.match;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.20.0)",
    comments = "Source: match.proto")
public final class MatchGrpc {

  private MatchGrpc() {}

  public static final String SERVICE_NAME = "match.Match";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.match.HelloRequest,
      io.grpc.examples.match.HelloReply> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = io.grpc.examples.match.HelloRequest.class,
      responseType = io.grpc.examples.match.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.match.HelloRequest,
      io.grpc.examples.match.HelloReply> getSayHelloMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.match.HelloRequest, io.grpc.examples.match.HelloReply> getSayHelloMethod;
    if ((getSayHelloMethod = MatchGrpc.getSayHelloMethod) == null) {
      synchronized (MatchGrpc.class) {
        if ((getSayHelloMethod = MatchGrpc.getSayHelloMethod) == null) {
          MatchGrpc.getSayHelloMethod = getSayHelloMethod = 
              io.grpc.MethodDescriptor.<io.grpc.examples.match.HelloRequest, io.grpc.examples.match.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "match.Match", "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.match.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.match.HelloReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MatchMethodDescriptorSupplier("SayHello"))
                  .build();
          }
        }
     }
     return getSayHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.match.QueryRequest,
      io.grpc.examples.match.QueryReply> getSentenceMatchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SentenceMatch",
      requestType = io.grpc.examples.match.QueryRequest.class,
      responseType = io.grpc.examples.match.QueryReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.match.QueryRequest,
      io.grpc.examples.match.QueryReply> getSentenceMatchMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.match.QueryRequest, io.grpc.examples.match.QueryReply> getSentenceMatchMethod;
    if ((getSentenceMatchMethod = MatchGrpc.getSentenceMatchMethod) == null) {
      synchronized (MatchGrpc.class) {
        if ((getSentenceMatchMethod = MatchGrpc.getSentenceMatchMethod) == null) {
          MatchGrpc.getSentenceMatchMethod = getSentenceMatchMethod = 
              io.grpc.MethodDescriptor.<io.grpc.examples.match.QueryRequest, io.grpc.examples.match.QueryReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "match.Match", "SentenceMatch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.match.QueryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.match.QueryReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MatchMethodDescriptorSupplier("SentenceMatch"))
                  .build();
          }
        }
     }
     return getSentenceMatchMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MatchStub newStub(io.grpc.Channel channel) {
    return new MatchStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MatchBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MatchBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MatchFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MatchFutureStub(channel);
  }

  /**
   * <pre>
   * The service definition.
   * </pre>
   */
  public static abstract class MatchImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sayHello(io.grpc.examples.match.HelloRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.match.HelloReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    /**
     */
    public void sentenceMatch(io.grpc.examples.match.QueryRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.match.QueryReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSentenceMatchMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.examples.match.HelloRequest,
                io.grpc.examples.match.HelloReply>(
                  this, METHODID_SAY_HELLO)))
          .addMethod(
            getSentenceMatchMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.examples.match.QueryRequest,
                io.grpc.examples.match.QueryReply>(
                  this, METHODID_SENTENCE_MATCH)))
          .build();
    }
  }

  /**
   * <pre>
   * The service definition.
   * </pre>
   */
  public static final class MatchStub extends io.grpc.stub.AbstractStub<MatchStub> {
    private MatchStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MatchStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MatchStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MatchStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sayHello(io.grpc.examples.match.HelloRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.match.HelloReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sentenceMatch(io.grpc.examples.match.QueryRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.match.QueryReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSentenceMatchMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The service definition.
   * </pre>
   */
  public static final class MatchBlockingStub extends io.grpc.stub.AbstractStub<MatchBlockingStub> {
    private MatchBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MatchBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MatchBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MatchBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public io.grpc.examples.match.HelloReply sayHello(io.grpc.examples.match.HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.examples.match.QueryReply sentenceMatch(io.grpc.examples.match.QueryRequest request) {
      return blockingUnaryCall(
          getChannel(), getSentenceMatchMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The service definition.
   * </pre>
   */
  public static final class MatchFutureStub extends io.grpc.stub.AbstractStub<MatchFutureStub> {
    private MatchFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MatchFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MatchFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MatchFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.match.HelloReply> sayHello(
        io.grpc.examples.match.HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.match.QueryReply> sentenceMatch(
        io.grpc.examples.match.QueryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSentenceMatchMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;
  private static final int METHODID_SENTENCE_MATCH = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MatchImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MatchImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((io.grpc.examples.match.HelloRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.match.HelloReply>) responseObserver);
          break;
        case METHODID_SENTENCE_MATCH:
          serviceImpl.sentenceMatch((io.grpc.examples.match.QueryRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.match.QueryReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MatchBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MatchBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.examples.match.MatchProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Match");
    }
  }

  private static final class MatchFileDescriptorSupplier
      extends MatchBaseDescriptorSupplier {
    MatchFileDescriptorSupplier() {}
  }

  private static final class MatchMethodDescriptorSupplier
      extends MatchBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MatchMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MatchGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MatchFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .addMethod(getSentenceMatchMethod())
              .build();
        }
      }
    }
    return result;
  }
}
