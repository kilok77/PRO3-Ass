package com.slaughterhouse.secondstation.cuttingStrategy;

import org.example.slaughter_house.grpc.Animal;
import org.example.slaughter_house.grpc.Part;
import org.example.slaughter_house.grpc.DatabaseServiceGrpc.DatabaseServiceBlockingStub;

import java.util.ArrayList;
import java.util.List;

public class PigCuttingStrategy extends AnimalCuttingStrategy {

    private DatabaseServiceBlockingStub databaseServiceStub;

    public PigCuttingStrategy(DatabaseServiceBlockingStub databaseServiceStub) {
        this.databaseServiceStub = databaseServiceStub;
    }

    @Override
    public List<Part> cutAnimal(Animal animal) {
        List<Part> parts = new ArrayList<>();
        double totalWeight = animal.getAnimalWeight();

        // Logic to cut the pig into parts
        double hamWeight = totalWeight * 0.4;
        double baconWeight = totalWeight * 0.3;
        double otherPartsWeight = totalWeight * 0.3;

        // Create and save parts using the default method from the interface
        parts.add(createAndSavePart("Ham", animal.getAnimalID(), hamWeight, databaseServiceStub));
        parts.add(createAndSavePart("Bacon", animal.getAnimalID(), baconWeight, databaseServiceStub));
        parts.add(createAndSavePart("OtherParts", animal.getAnimalID(), otherPartsWeight, databaseServiceStub));

        return parts;
    }
}

