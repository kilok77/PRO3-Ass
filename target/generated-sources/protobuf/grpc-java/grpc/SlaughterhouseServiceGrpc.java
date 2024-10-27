package grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: slaughterhouse.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SlaughterhouseServiceGrpc {

  private SlaughterhouseServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "SlaughterhouseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Slaughterhouse.GetAnimalProductsRequest,
      grpc.Slaughterhouse.GetAnimalProductsResponse> getGetAnimalProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnimalProducts",
      requestType = grpc.Slaughterhouse.GetAnimalProductsRequest.class,
      responseType = grpc.Slaughterhouse.GetAnimalProductsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Slaughterhouse.GetAnimalProductsRequest,
      grpc.Slaughterhouse.GetAnimalProductsResponse> getGetAnimalProductsMethod() {
    io.grpc.MethodDescriptor<grpc.Slaughterhouse.GetAnimalProductsRequest, grpc.Slaughterhouse.GetAnimalProductsResponse> getGetAnimalProductsMethod;
    if ((getGetAnimalProductsMethod = SlaughterhouseServiceGrpc.getGetAnimalProductsMethod) == null) {
      synchronized (SlaughterhouseServiceGrpc.class) {
        if ((getGetAnimalProductsMethod = SlaughterhouseServiceGrpc.getGetAnimalProductsMethod) == null) {
          SlaughterhouseServiceGrpc.getGetAnimalProductsMethod = getGetAnimalProductsMethod =
              io.grpc.MethodDescriptor.<grpc.Slaughterhouse.GetAnimalProductsRequest, grpc.Slaughterhouse.GetAnimalProductsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAnimalProducts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Slaughterhouse.GetAnimalProductsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Slaughterhouse.GetAnimalProductsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterhouseServiceMethodDescriptorSupplier("GetAnimalProducts"))
              .build();
        }
      }
    }
    return getGetAnimalProductsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Slaughterhouse.GetProductAnimalsRequest,
      grpc.Slaughterhouse.GetProductAnimalsResponse> getGetProductAnimalsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProductAnimals",
      requestType = grpc.Slaughterhouse.GetProductAnimalsRequest.class,
      responseType = grpc.Slaughterhouse.GetProductAnimalsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Slaughterhouse.GetProductAnimalsRequest,
      grpc.Slaughterhouse.GetProductAnimalsResponse> getGetProductAnimalsMethod() {
    io.grpc.MethodDescriptor<grpc.Slaughterhouse.GetProductAnimalsRequest, grpc.Slaughterhouse.GetProductAnimalsResponse> getGetProductAnimalsMethod;
    if ((getGetProductAnimalsMethod = SlaughterhouseServiceGrpc.getGetProductAnimalsMethod) == null) {
      synchronized (SlaughterhouseServiceGrpc.class) {
        if ((getGetProductAnimalsMethod = SlaughterhouseServiceGrpc.getGetProductAnimalsMethod) == null) {
          SlaughterhouseServiceGrpc.getGetProductAnimalsMethod = getGetProductAnimalsMethod =
              io.grpc.MethodDescriptor.<grpc.Slaughterhouse.GetProductAnimalsRequest, grpc.Slaughterhouse.GetProductAnimalsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProductAnimals"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Slaughterhouse.GetProductAnimalsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Slaughterhouse.GetProductAnimalsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterhouseServiceMethodDescriptorSupplier("GetProductAnimals"))
              .build();
        }
      }
    }
    return getGetProductAnimalsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SlaughterhouseServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceStub>() {
        @java.lang.Override
        public SlaughterhouseServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SlaughterhouseServiceStub(channel, callOptions);
        }
      };
    return SlaughterhouseServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SlaughterhouseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceBlockingStub>() {
        @java.lang.Override
        public SlaughterhouseServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SlaughterhouseServiceBlockingStub(channel, callOptions);
        }
      };
    return SlaughterhouseServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SlaughterhouseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceFutureStub>() {
        @java.lang.Override
        public SlaughterhouseServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SlaughterhouseServiceFutureStub(channel, callOptions);
        }
      };
    return SlaughterhouseServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getAnimalProducts(grpc.Slaughterhouse.GetAnimalProductsRequest request,
        io.grpc.stub.StreamObserver<grpc.Slaughterhouse.GetAnimalProductsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAnimalProductsMethod(), responseObserver);
    }

    /**
     */
    default void getProductAnimals(grpc.Slaughterhouse.GetProductAnimalsRequest request,
        io.grpc.stub.StreamObserver<grpc.Slaughterhouse.GetProductAnimalsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProductAnimalsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SlaughterhouseService.
   */
  public static abstract class SlaughterhouseServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SlaughterhouseServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SlaughterhouseService.
   */
  public static final class SlaughterhouseServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SlaughterhouseServiceStub> {
    private SlaughterhouseServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SlaughterhouseServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SlaughterhouseServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAnimalProducts(grpc.Slaughterhouse.GetAnimalProductsRequest request,
        io.grpc.stub.StreamObserver<grpc.Slaughterhouse.GetAnimalProductsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnimalProductsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getProductAnimals(grpc.Slaughterhouse.GetProductAnimalsRequest request,
        io.grpc.stub.StreamObserver<grpc.Slaughterhouse.GetProductAnimalsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProductAnimalsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SlaughterhouseService.
   */
  public static final class SlaughterhouseServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SlaughterhouseServiceBlockingStub> {
    private SlaughterhouseServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SlaughterhouseServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SlaughterhouseServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.Slaughterhouse.GetAnimalProductsResponse getAnimalProducts(grpc.Slaughterhouse.GetAnimalProductsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnimalProductsMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Slaughterhouse.GetProductAnimalsResponse getProductAnimals(grpc.Slaughterhouse.GetProductAnimalsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProductAnimalsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SlaughterhouseService.
   */
  public static final class SlaughterhouseServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SlaughterhouseServiceFutureStub> {
    private SlaughterhouseServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SlaughterhouseServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SlaughterhouseServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Slaughterhouse.GetAnimalProductsResponse> getAnimalProducts(
        grpc.Slaughterhouse.GetAnimalProductsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnimalProductsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Slaughterhouse.GetProductAnimalsResponse> getProductAnimals(
        grpc.Slaughterhouse.GetProductAnimalsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProductAnimalsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ANIMAL_PRODUCTS = 0;
  private static final int METHODID_GET_PRODUCT_ANIMALS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ANIMAL_PRODUCTS:
          serviceImpl.getAnimalProducts((grpc.Slaughterhouse.GetAnimalProductsRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Slaughterhouse.GetAnimalProductsResponse>) responseObserver);
          break;
        case METHODID_GET_PRODUCT_ANIMALS:
          serviceImpl.getProductAnimals((grpc.Slaughterhouse.GetProductAnimalsRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Slaughterhouse.GetProductAnimalsResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetAnimalProductsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.Slaughterhouse.GetAnimalProductsRequest,
              grpc.Slaughterhouse.GetAnimalProductsResponse>(
                service, METHODID_GET_ANIMAL_PRODUCTS)))
        .addMethod(
          getGetProductAnimalsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.Slaughterhouse.GetProductAnimalsRequest,
              grpc.Slaughterhouse.GetProductAnimalsResponse>(
                service, METHODID_GET_PRODUCT_ANIMALS)))
        .build();
  }

  private static abstract class SlaughterhouseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SlaughterhouseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Slaughterhouse.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SlaughterhouseService");
    }
  }

  private static final class SlaughterhouseServiceFileDescriptorSupplier
      extends SlaughterhouseServiceBaseDescriptorSupplier {
    SlaughterhouseServiceFileDescriptorSupplier() {}
  }

  private static final class SlaughterhouseServiceMethodDescriptorSupplier
      extends SlaughterhouseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SlaughterhouseServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SlaughterhouseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SlaughterhouseServiceFileDescriptorSupplier())
              .addMethod(getGetAnimalProductsMethod())
              .addMethod(getGetProductAnimalsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
