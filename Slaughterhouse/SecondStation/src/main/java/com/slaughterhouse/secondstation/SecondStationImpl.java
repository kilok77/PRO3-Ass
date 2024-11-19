package com.slaughterhouse.secondstation;

import com.slaughterhouse.secondstation.cuttingStrategy.AnimalCuttingStrategy;
import com.slaughterhouse.secondstation.cuttingStrategy.CuttingStrategyFactory;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.slaughter_house.grpc.*;

import java.util.List;

@GrpcService
public class SecondStationImpl extends SecondStationServiceGrpc.SecondStationServiceImplBase {

    @GrpcClient("databaseService")
    private DatabaseServiceGrpc.DatabaseServiceBlockingStub databaseServiceStub;

    @Override
    public void cutAnimal(CutAnimalRequest request, StreamObserver<CutAnimalResponse> responseObserver) {
        try {
            // Get the animal type from the request
            Animal animal = request.getAnimal();
            System.out.println(animal.toString());

            // Get the appropriate cutting strategy for the animal
            AnimalCuttingStrategy cuttingStrategy = CuttingStrategyFactory.getCuttingStrategy(animal.getAnimalType(), databaseServiceStub);

            System.out.println(cuttingStrategy.toString());
            // Cut the animal and get the parts
            List<Part> parts = cuttingStrategy.cutAnimal(animal);

            // Create a response
            CutAnimalResponse response = CutAnimalResponse.newBuilder()
                    .addAllParts(parts)  // Add all parts to the response
                    .build();

            // Send the response
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (Exception e) {
            // Handle errors
            responseObserver.onError(new Throwable("Failed to cut animal: " + e.getMessage()));
        }
    }


}
