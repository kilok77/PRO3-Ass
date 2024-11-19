package com.slaughterhouse.secondstation.cuttingStrategy;
import org.example.slaughter_house.grpc.Animal;
import org.example.slaughter_house.grpc.Part;
import org.example.slaughter_house.grpc.DatabaseServiceGrpc.DatabaseServiceBlockingStub;

import java.util.ArrayList;
import java.util.List;

public class ChickenCuttingStrategy extends AnimalCuttingStrategy {

    private DatabaseServiceBlockingStub databaseServiceStub;

    public ChickenCuttingStrategy(DatabaseServiceBlockingStub databaseServiceStub) {
        this.databaseServiceStub = databaseServiceStub;
    }

    @Override
    public List<Part> cutAnimal(Animal animal) {
        List<Part> parts = new ArrayList<>();
        double totalWeight = animal.getAnimalWeight();

        // Logic to cut the chicken into parts
        double breastWeight = totalWeight * 0.4; // Chicken breast is typically the largest part
        double wingWeight = totalWeight * 0.2;  // Wings are typically smaller
        double legWeight = totalWeight * 0.2;   // Legs can vary, but a common proportion
        double thighWeight = totalWeight * 0.2; // Thighs also typically account for a similar weight

        // Create and save parts using the default method from the interface
        parts.add(createAndSavePart("Breast", animal.getAnimalID(), breastWeight, databaseServiceStub));
        parts.add(createAndSavePart("Wings", animal.getAnimalID(), wingWeight, databaseServiceStub));
        parts.add(createAndSavePart("Legs", animal.getAnimalID(), legWeight, databaseServiceStub));
        parts.add(createAndSavePart("Thighs", animal.getAnimalID(), thighWeight, databaseServiceStub));

        return parts;
    }
}

