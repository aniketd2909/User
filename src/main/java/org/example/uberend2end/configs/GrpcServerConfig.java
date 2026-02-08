package org.example.uberend2end.configs;

import io.grpc.ServerBuilder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.uberend2end.services.RideService;
import org.example.uberend2end.services.UserService;
import org.springframework.context.annotation.Configuration;
import io.grpc.Server;

import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class GrpcServerConfig {

    @Value("${grpc.server.port:9090}")
    private int grpcServerPort;

    private final RideService rideService;
    private Server server;

    @PostConstruct
    public void startGrpcServer() throws IOException {
        server = ServerBuilder
                .forPort(grpcServerPort)
                .addService(rideService)
                .build()
                .start();

        System.out.println("gRPC Server started on port " + grpcServerPort);

        new Thread(() -> {
            try {
                if( server != null ) {
                    server.awaitTermination();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("gRPC Server interrupted");
            }
        }).start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gRPC Server...");
            if( server != null ) {
                server.shutdown();
            }
        }));

    }

}
