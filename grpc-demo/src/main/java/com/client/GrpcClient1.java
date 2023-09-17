package com.client;

import com.suns.HelloProto;
import com.suns.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient1 {

    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8089).usePlaintext().build();

        HelloServiceGrpc.HelloServiceBlockingStub helloServiceProxy = HelloServiceGrpc.newBlockingStub(managedChannel);

        HelloProto.HelloRequest.Builder builder = HelloProto.HelloRequest.newBuilder();
        builder.setName("susan");
        HelloProto.HelloRequest helloRequest = builder.build();

        HelloProto.HelloResponse helloResponse = helloServiceProxy.hello(helloRequest);
        System.out.println("-----------------" + helloResponse.getResult());
    }

}
