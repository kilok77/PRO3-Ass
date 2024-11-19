package com.slaughterhouse.secondstation.cuttingStrategy;

import org.example.slaughter_house.grpc.DatabaseServiceGrpc;

public class CuttingStrategyFactory {
    public static AnimalCuttingStrategy getCuttingStrategy(String animalType, DatabaseServiceGrpc.DatabaseServiceBlockingStub serviceBlockingStub) {
        switch (animalType.toLowerCase()) {
            case "cow":
                return new CowCuttingStrategy(serviceBlockingStub);
            case "pig":
                return new PigCuttingStrategy(serviceBlockingStub);
            case "chicken":
                return new ChickenCuttingStrategy(serviceBlockingStub);
            default:
                throw new IllegalArgumentException("Unknown animal type: " + animalType);
        }
    }
}
