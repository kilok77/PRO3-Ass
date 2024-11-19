package com.slaughterhouse.firststation;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.slaughter_house.grpc.*;

@GrpcService
public class FirstStationImpl extends FirstStationServiceGrpc.FirstStationServiceImplBase {

    @GrpcClient("databaseService")
    private DatabaseServiceGrpc.DatabaseServiceBlockingStub databaseServiceStub;


    @Override
    public void registerAnimal(RegisterAnimalRequest request, StreamObserver<Animal> responseObserver) {

        CreateAnimalRequest createAnimalRequest = CreateAnimalRequest.newBuilder().setAnimalType(request.getAnimalType()).setAnimalWeight(request.getAnimalWeight()).build();

        // Call the createAnimal method and receive the response
        Animal animalResponse = databaseServiceStub.createAnimal(createAnimalRequest);


        responseObserver.onNext(animalResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void weightAnimal(WeightAnimalRequest request, StreamObserver<Animal> responseObserver) {


        Animal animalResponse = databaseServiceStub.getAnimal(GetAnimalRequest.newBuilder().setAnimalId(request.getAnimalId()).build());

        responseObserver.onNext(animalResponse);
        responseObserver.onCompleted();
    }
}
