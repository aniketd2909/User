package org.example.uberend2end.configs;

import java.io.IOException;

import org.example.uberend2end.services.implementation.RideService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class GrpcServerConfig {

    @Value("${grpc.server.port:9090}")
    private int grpcServerPort;

    private final RideService rideService;// Inject the new service
    private Server server;

    @PostConstruct
    public void startGrpcServer() throws IOException {
        server = ServerBuilder
                .forPort(grpcServerPort)
                .addService(rideService)
                .build()
                .start();
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
