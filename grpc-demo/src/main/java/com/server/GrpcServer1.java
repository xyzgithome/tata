package com.server;

import com.server.impl.HelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer1 {

    public static void main(String[] args) throws InterruptedException, IOException {
        ServerBuilder<?> serverBuilder = ServerBuilder.forPort(8089);
        serverBuilder.addService(new HelloServiceImpl());
        Server server = serverBuilder.build();
        server.start();
        server.awaitTermination();
    }
}
