package client;

import grpc.Slaughterhouse.*;
//import grpc.*;
import grpc.SlaughterhouseServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;


import java.util.concurrent.TimeUnit;

public class SlaughterhouseClient {
    private final ManagedChannel channel;
    private final SlaughterhouseServiceGrpc.SlaughterhouseServiceBlockingStub blockingStub;

    public SlaughterhouseClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext() // Disable SSL for simplicity
                .build();
        blockingStub = SlaughterhouseServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }


    public static void main(String[] args) throws InterruptedException {
        SlaughterhouseClient client = new SlaughterhouseClient("localhost", 50051);

        try {
            // Call the GetAnimalProducts RPC method with a sample animalId
            GetAnimalProductsRequest getAnimalProductsRequest = GetAnimalProductsRequest.newBuilder()
                    .setAnimalId(1)  // Sample animalId
                    .build();
            GetAnimalProductsResponse getAnimalProductsResponse = client.blockingStub
                    .getAnimalProducts(getAnimalProductsRequest);

            // Print the response for GetAnimalProducts
            System.out.println("GetAnimalProducts Response: " + getAnimalProductsResponse);

            // Call the GetProductAnimals RPC method with a sample productId
            GetProductAnimalsRequest getProductAnimalsRequest = GetProductAnimalsRequest.newBuilder()
                    .setProductId(1)  // Sample productId
                    .build();
            GetProductAnimalsResponse getProductAnimalsResponse = client.blockingStub
                    .getProductAnimals(getProductAnimalsRequest);

            // Print the response for GetProductAnimals
            System.out.println("GetProductAnimals Response: " + getProductAnimalsResponse);

        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        } finally {
            // Shut down the client
            client.shutdown();
        }
    }
}