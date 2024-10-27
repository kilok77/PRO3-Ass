package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class SlaughterhouseServer {
    private final int port = 50051; // gRPC port
    private final Server server;

    public SlaughterhouseServer() {
        server = ServerBuilder.forPort(port)
                .addService(new  SlaughterhouseServiceImpl())
                .build();
    }

    public void start() throws IOException {
        server.start();
        System.out.println("Server started on port " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("Shutting down gRPC server since JVM is shutting down");
            SlaughterhouseServer.this.stop();
            System.err.println("Server shut down");
        }));

        // Keep the server running
        try {
            server.awaitTermination();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Server interrupted: " + e.getMessage());
        }
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    public static void main(String[] args) throws IOException {
        final SlaughterhouseServer server = new SlaughterhouseServer();
        server.start();
    }
}
