package com.slaughterhouse.secondstation.cuttingStrategy;

import org.example.slaughter_house.grpc.Animal;
import org.example.slaughter_house.grpc.Part;
import org.example.slaughter_house.grpc.DatabaseServiceGrpc.DatabaseServiceBlockingStub;

import java.util.ArrayList;
import java.util.List;

public class CowCuttingStrategy extends AnimalCuttingStrategy {

    private DatabaseServiceBlockingStub databaseServiceStub;

    public CowCuttingStrategy(DatabaseServiceBlockingStub databaseServiceStub) {
        this.databaseServiceStub = databaseServiceStub;
    }

    @Override
    public List<Part> cutAnimal(Animal animal) {
        List<Part> parts = new ArrayList<>();
        double totalWeight = animal.getAnimalWeight();

        // Logic to cut the cow into parts
        double steakWeight = totalWeight * 0.3;
        double ribsWeight = totalWeight * 0.2;
        double otherPartsWeight = totalWeight * 0.5;

        // Create and save parts using the default method from the interface
        parts.add(createAndSavePart("Steak", animal.getAnimalID(), steakWeight, databaseServiceStub));
        parts.add(createAndSavePart("Ribs", animal.getAnimalID(), ribsWeight, databaseServiceStub));
        parts.add(createAndSavePart("OtherParts", animal.getAnimalID(), otherPartsWeight, databaseServiceStub));

        return parts;
    }

}
