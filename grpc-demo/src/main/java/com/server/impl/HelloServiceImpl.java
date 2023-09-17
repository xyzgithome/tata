package com.server.impl;

import com.suns.HelloProto;
import com.suns.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(HelloProto.HelloRequest request, StreamObserver<HelloProto.HelloResponse> responseObserver) {
        String name = request.getName();
        System.out.println("---------------name--------------" + name);

        HelloProto.HelloResponse.Builder builder = HelloProto.HelloResponse.newBuilder();
        builder.setResult("hello method invoke ok, name=" + name);
        HelloProto.HelloResponse build = builder.build();

        responseObserver.onNext(build);
        responseObserver.onCompleted();
    }
}
