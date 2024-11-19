package com.slaughterhouse.database;

import com.slaughterhouse.database.model.TableAnimal;
import com.slaughterhouse.database.model.TablePart;
import com.slaughterhouse.database.service.AnimalService;
import com.slaughterhouse.database.service.PartService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.slaughter_house.grpc.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class DatabaseImpl extends DatabaseServiceGrpc.DatabaseServiceImplBase {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private PartService partService;

    // Helper method to map from Java Animal entity to Proto Animal message
    private Animal toProtoAnimal(TableAnimal tableAnimalEntity) {
        return Animal.newBuilder()
                .setAnimalID(tableAnimalEntity.getAnimalId())  // Mapping ID
                .setAnimalType(tableAnimalEntity.getAnimalType())  // Mapping Type
                .setAnimalWeight(tableAnimalEntity.getAnimalWeight())  // Mapping weight
                .build();
    }

    private Part convertTablePartToPart(TablePart tablePart) {
        return Part.newBuilder()
                .setPartId(tablePart.getPartId())
                .setPartType(tablePart.getPartType())
                .setPartWeight(tablePart.getPartWeight())
                .setAnimalId(tablePart.getAnimalId())  // Or map the whole TableAnimal if needed
                .build();
    }


    @Override
    public void getAnimal(GetAnimalRequest request, StreamObserver<Animal> responseObserver) {
        // Fetch the animal from the service layer
        TableAnimal tableAnimalEntity = animalService.getAnimalById(request.getAnimalId()).orElse(null);

        // If the animal is found, convert to Proto Animal and send as response
        if (tableAnimalEntity != null) {
            Animal animalProto = toProtoAnimal(tableAnimalEntity);
            responseObserver.onNext(animalProto);
        } else {
            // Handle the case where animal is not found, you may want to return an error or null.
            responseObserver.onError(new RuntimeException("Animal not found"));
        }
        responseObserver.onCompleted();
    }

    @Override
    public void createAnimal(CreateAnimalRequest request, StreamObserver<Animal> responseObserver) {
        // Create a new Animal entity from the request
        TableAnimal tableAnimalEntity = new TableAnimal();
        tableAnimalEntity.setAnimalType(request.getAnimalType());
        tableAnimalEntity.setAnimalWeight(request.getAnimalWeight());
        tableAnimalEntity.setOrigin(request.getOrigin());
        tableAnimalEntity.setCreated(new Date());

        // Save the animal entity using the service
        tableAnimalEntity = animalService.saveAnimal(tableAnimalEntity);

        // Convert the saved entity to Proto Animal and send as response
        Animal animalProto = toProtoAnimal(tableAnimalEntity);
        responseObserver.onNext(animalProto);
        responseObserver.onCompleted();
    }

    @Override
    public void createPart(CreatePartRequest request, StreamObserver<Part> part) {
        // Create a new TablePart instance
        TablePart tablePart = new TablePart();
        tablePart.setPartType(request.getPartType());
        tablePart.setPartWeight(request.getPartWeight());
        tablePart.setAnimalId(request.getAnimalId());  // Set just the animalId directly

        // Save the TablePart to the database
        tablePart = partService.savePart(tablePart);  // assuming you have a tablePartRepository to persist it

        // Return the created Part (convert TablePart to Part if needed)
        Part partResponse = convertTablePartToPart(tablePart);  // assuming a method to convert
        part.onNext(partResponse);
        part.onCompleted();
    }

    @Override
    public void getAnimalsByOrigin(GetAnimalsByOriginRequest request, StreamObserver<Animals> responseObserver) {
        // Retrieve the list of animals from the service layer by origin
        List<TableAnimal> animalsList = animalService.getAnimalsByOrigin(request.getOrigin());

        // Create the Animals proto message
        Animals.Builder animalsBuilder = Animals.newBuilder();

        // If animals are found, convert them to Proto Animal and add them to the Animals builder
        if (animalsList != null && !animalsList.isEmpty()) {
            List<Animal> animalsProto = animalsList.stream()
                    .map(this::toProtoAnimal)  // Map TableAnimal to Proto Animal
                    .collect(Collectors.toList());

            // Add all animals to the Animals builder
            animalsBuilder.addAllAnimal(animalsProto);
        }

        // Build the Animals message and send it
        responseObserver.onNext(animalsBuilder.build());
        responseObserver.onCompleted();
    }
}
