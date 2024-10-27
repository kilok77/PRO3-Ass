package server;

import grpc.SlaughterhouseServiceGrpc;
import grpc.Slaughterhouse.*;
import io.grpc.stub.StreamObserver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SlaughterhouseServiceImpl extends SlaughterhouseServiceGrpc.SlaughterhouseServiceImplBase {
    private final List<Animal> animals = new ArrayList<>();
    private final List<Product> products = new ArrayList<>();


    public SlaughterhouseServiceImpl() {
        loadAnimalsFromDatabase();
        loadProductsFromDatabase();
    }

    private void loadAnimalsFromDatabase() {
        try (Statement stmt = DatabaseConnection.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery("SELECT AnimalId, AnimalType, Weight FROM Animal")) {

            while (rs.next()) {
                animals.add(Animal.newBuilder()
                        .setAnimalId(rs.getInt("AnimalId"))
                        .setAnimalType(rs.getString("AnimalType"))
                        .setWeight(rs.getDouble("Weight"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadProductsFromDatabase() {
        try (Connection connection = DatabaseConnection.getConnection()) {

            // Load OnePartProducts
            try (PreparedStatement stmt = connection.prepareStatement(
                    "SELECT OnePartProduct.ProductId AS ProductId, Part.PartId AS PartId, " +
                            "Part.PartType AS PartType, Part.Weight AS Weight " +
                            "FROM OnePartProduct " +
                            "JOIN Part ON OnePartProduct.PartId = Part.PartId")) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Part part = Part.newBuilder()
                            .setPartId(rs.getInt("PartId"))
                            .setPartType(rs.getString("PartType"))
                            .setWeight(rs.getDouble("Weight"))
                            .build();
                    products.add(Product.newBuilder()
                            .setOnePart(OnePart.newBuilder().setPart(part))
                            .build());
                }
            }

            // Load MixedProducts
            try (PreparedStatement stmt = connection.prepareStatement(
                    "SELECT mp.ProductId AS ProductId, p.PartId AS PartId, p.PartType AS PartType, p.Weight AS Weight " +
                            "FROM MixedProduct mp " +
                            "JOIN MixedProductParts mpp ON mp.ProductId = mpp.ProductId " +
                            "JOIN Part p ON mpp.PartId = p.PartId " +
                            "ORDER BY mp.ProductId")) {
                ResultSet rs = stmt.executeQuery();
                Mixed.Builder mixedProduct = Mixed.newBuilder();
                int lastProductId = -1;

                while (rs.next()) {
                    int productId = rs.getInt("ProductId");
                    Part part = Part.newBuilder()
                            .setPartId(rs.getInt("PartId"))
                            .setPartType(rs.getString("PartType"))
                            .setWeight(rs.getDouble("Weight"))
                            .build();

                    if (productId != lastProductId) {
                        if (lastProductId != -1) {
                            products.add(Product.newBuilder().setMixed(mixedProduct).build());
                        }
                        mixedProduct = Mixed.newBuilder().addParts(part);
                        lastProductId = productId;
                    } else {
                        mixedProduct.addParts(part);
                    }
                }
                if (lastProductId != -1) {
                    products.add(Product.newBuilder().setMixed(mixedProduct).build());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void getAnimalProducts(GetAnimalProductsRequest request, StreamObserver<GetAnimalProductsResponse> responseObserver) {
        int animalId = request.getAnimalId();
        GetAnimalProductsResponse.Builder responseBuilder = GetAnimalProductsResponse.newBuilder();

        for (Product product : products) {
            responseBuilder.addProducts(product);
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getProductAnimals(GetProductAnimalsRequest request, StreamObserver<GetProductAnimalsResponse> responseObserver) {
        int productId = request.getProductId();
        GetProductAnimalsResponse.Builder responseBuilder = GetProductAnimalsResponse.newBuilder();

        for (Animal animal : animals) {
            responseBuilder.addAnimals(animal);
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }
}

