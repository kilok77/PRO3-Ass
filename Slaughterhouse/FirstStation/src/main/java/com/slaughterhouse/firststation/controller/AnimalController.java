package com.slaughterhouse.firststation.controller;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.JsonFormat;
import com.google.protobuf.util.Timestamps;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.example.slaughter_house.grpc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @GrpcClient("databaseService")
    private DatabaseServiceGrpc.DatabaseServiceBlockingStub databaseServiceStub;

    record NewRegisterAnimalRequest(String animalType, double animalWeight, String origin) {}

//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public Animal registerAnimal(@RequestBody NewRegisterAnimalRequest request) {
//        System.out.println(request);
//        // Map the incoming request to the gRPC request
//        CreateAnimalRequest createAnimalRequest = CreateAnimalRequest.newBuilder()
//                .setAnimalType(request.animalType)
//                .setAnimalWeight(request.animalWeight)
//                .setOrigin(request.origin) // Convert LocalDate to String (ISO format)
//                .build();
//
//        // Call the gRPC service to register the animal
//        Animal animalResponse = databaseServiceStub.createAnimal(createAnimalRequest);
//
//        // Return the registered animal response
//        return animalResponse;
//    }

    // Test POST method to receive raw JSON as a Map
    @PostMapping(value = "/test", consumes = "application/json")
    public String testPost(@RequestBody Map<String, Object> data) {
        return "Received: " + data.toString();
    }

    @PostMapping(consumes = "application/json")
    public String createAnimal(@RequestBody RegisterAnimalRequest request) throws InvalidProtocolBufferException {
        // Create gRPC request from REST API request
        System.out.println(request.getAnimalType());
        System.out.println(request.getAnimalWeight());
        System.out.println(request.getOrigin());

        CreateAnimalRequest grpcRequest = CreateAnimalRequest.newBuilder()
                .setAnimalType(request.getAnimalType())
                .setAnimalWeight(request.getAnimalWeight())
                .setOrigin(request.getOrigin())
                .build();

        // Call gRPC service to save the animal and get a response
        Animal response = databaseServiceStub.createAnimal(grpcRequest);
        String json = JsonFormat.printer().print(response);
        return json;
    }

    @GetMapping("/{id}")
    public String getAnimalById(@PathVariable Long id) throws InvalidProtocolBufferException {
        System.out.println(id);
        // Prepare the gRPC request
        GetAnimalRequest getAnimalRequest = GetAnimalRequest.newBuilder().setAnimalId(id).build();
//
//        // Call the gRPC service to retrieve the animal by ID
        Animal animalResponse = databaseServiceStub.getAnimal(getAnimalRequest);
        String json = JsonFormat.printer().print(animalResponse);
        return json;
    }

    private Timestamp parseDate(String dateString) {
        Instant instant = Instant.parse(dateString);  // Assuming ISO 8601 format
        return Timestamps.fromMillis(instant.toEpochMilli());
    }

    // Method to filter animals by createdAt date
    @GetMapping("/date/{date}")
    public List<Animal> getAnimalsByDate(@PathVariable String date) {
        // Convert the date string to a Timestamp
        Timestamp createdAt = parseDate(date);
        GetAnimalsByCreatedAtRequest request = GetAnimalsByCreatedAtRequest.newBuilder()
                .setCreatedAt(createdAt)
                .build();

        // Call the gRPC service to get animals by createdAt date
        Animals animalsResponse = databaseServiceStub.getAnimalsByCreatedAt(request);
        return animalsResponse.getAnimalList(); // Assuming the response contains a list of animals
    }

    // Method to filter animals by origin
    @GetMapping("/origin/{origin}")
    public String getAnimalsByOrigin(@PathVariable String origin) {
        // Call the gRPC service to get animals by origin
        GetAnimalsByOriginRequest request = GetAnimalsByOriginRequest.newBuilder()
                .setOrigin(origin)
                .build();

        Animals animalsResponse = databaseServiceStub.getAnimalsByOrigin(request);

        // Convert the response to JSON
        try {
            String json = JsonFormat.printer().print(animalsResponse);
            return json;
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return "Error converting response to JSON";
        }
    }
}