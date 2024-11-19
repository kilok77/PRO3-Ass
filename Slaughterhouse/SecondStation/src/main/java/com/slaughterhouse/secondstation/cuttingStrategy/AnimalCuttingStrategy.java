package com.slaughterhouse.secondstation.cuttingStrategy;

import org.example.slaughter_house.grpc.Animal;
import org.example.slaughter_house.grpc.CreatePartRequest;
import org.example.slaughter_house.grpc.Part;
import org.example.slaughter_house.grpc.DatabaseServiceGrpc.DatabaseServiceBlockingStub;

import java.util.List;

public abstract class AnimalCuttingStrategy {

    public abstract List<Part> cutAnimal(Animal animal);

    // Default method to create and save parts, shared by all strategies
    public Part createAndSavePart(String name, long animalId, double weight, DatabaseServiceBlockingStub databaseServiceStub) {

        CreatePartRequest request = CreatePartRequest.newBuilder().setPartType(name).setPartWeight(weight).setAnimalId(animalId).build();
        // Create part in the database

        // Persist part in the database
        Part part = databaseServiceStub.createPart(request); // Assuming this persists the part and returns it

        return part; // Return the created part
    }
}
