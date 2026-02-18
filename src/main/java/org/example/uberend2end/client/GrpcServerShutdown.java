package org.example.uberend2end.client;

import java.util.concurrent.TimeUnit;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.grpc.Server;

@Component
public class GrpcServerShutdown {

    @Autowired(required = false)
    private Server grpcServer;

    @PreDestroy
    public void shutdownGrpcServer() {
        if (grpcServer != null && !grpcServer.isShutdown()) {
            System.out.println(">>> Initiating gRPC server graceful shutdown...");
            
            // Start graceful shutdown - stops accepting new requests
            grpcServer.shutdown();
            
            try {
                // Wait up to 30 seconds for active RPCs to complete
                if (!grpcServer.awaitTermination(30, TimeUnit.SECONDS)) {
                    System.err.println(">>> gRPC server didn't shut down gracefully, forcing shutdown...");
                    
                    // Force shutdown if graceful didn't work
                    grpcServer.shutdownNow();
                    
                    // Wait a bit more for forced shutdown
                    if (!grpcServer.awaitTermination(5, TimeUnit.SECONDS)) {
                        System.err.println(">>> gRPC server didn't terminate completely");
                    }
                } else {
                    System.out.println(">>> gRPC server shut down gracefully");
                }
            } catch (InterruptedException e) {
                System.err.println(">>> Shutdown interrupted, forcing immediate shutdown...");
                grpcServer.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
}
