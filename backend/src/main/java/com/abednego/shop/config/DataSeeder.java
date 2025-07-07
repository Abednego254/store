import com.abednego.shop.model.ProductLine;
import com.abednego.shop.repository.ProductLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final ProductLineRepository productLineRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productLineRepository.count() > 0) return;

        Map<String, List<String>> seed = Map.of(
                "Classic Cars", List.of("Premium detailed vintage cars", "<p>Classic Cars</p>", "cars.jpg"),
                "Planes", List.of("Wings that soar", "<p>Plane models</p>", "planes.jpg"),
                "Ships", List.of("Ocean glory and details", "<p>Ships Galore</p>", "ships.jpg"),
                "Trains", List.of("Locomotive Precision", "<p>Train Series</p>", "trains.jpg"),
                "Trucks and Buses", List.of("Heavy Duty Models", "<p>Transport Vehicles</p>", "trucksandbuses.jpg"),
                "Motorcycles", List.of("Speed and style combined", "<p>Motorbikes Collection</p>", "motorcycles.jpg")
        );

        String imageDirectory = "src/main/resources/static/images/";
        List<ProductLine> productLines = seed.entrySet().stream()
                .map(e -> {
                    try{
                        return ProductLine.builder()
                                .productLine(e.getKey())
                                .textDescription(e.getValue().get(0))
                                .htmlDescription(e.getValue().get(1))
                                .image(Files.readAllBytes(Path.of(imageDirectory, e.getValue().get(2))))
                                .build();
                    }catch (IOException ex){
                        throw new UncheckedIOException(ex);
                    }
                })
                .toList();
        productLineRepository.saveAll(productLines);
    }
}





/*
package com.abednego.shop.config;

import com.abednego.shop.model.ProductLine;
import com.abednego.shop.repository.ProductLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final ProductLineRepository productLineRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productLineRepository.count() == 0) {
            byte[] cars = Files.readAllBytes(Paths.get("src/main/resources/static/images/cars.jpg"));
            byte[] planes = Files.readAllBytes(Paths.get("src/main/resources/static/images/planes.jpg"));
            byte[] ships = Files.readAllBytes(Paths.get("src/main/resources/static/images/ships.jpg"));
            byte[] trains = Files.readAllBytes(Paths.get("src/main/resources/static/images/trains.jpg"));
            byte[] trucks = Files.readAllBytes(Paths.get("src/main/resources/static/images/trucksandbuses.jpg"));
            byte[] motorcycles = Files.readAllBytes(Paths.get("src/main/resources/static/images/motorcycles.jpg"));

            productLineRepository.saveAll(List.of(
                ProductLine.builder()
                        .productLine("Classic Cars")
                        .textDescription("Premium detailed vintage cars")
                        .htmlDescription("<p>Classic cars</p>")
                        .image(cars)
                        .build(),

                ProductLine.builder()
                        .productLine("Planes")
                        .textDescription("Wings that soar")
                        .htmlDescription("<p>Plane models</p>")
                        .image(planes)
                        .build(),

                ProductLine.builder()
                        .productLine("Ships")
                        .textDescription("Ocean glory and details")
                        .htmlDescription("<p>Ships galore</p>")
                        .image(ships)
                        .build(),

                ProductLine.builder()
                        .productLine("Trains")
                        .textDescription("Locomotive precision")
                        .htmlDescription("<p>Train series</p>")
                        .image(trains)
                        .build(),

                ProductLine.builder()
                        .productLine("Trucks and Buses")
                        .textDescription("Heavy-duty models")
                        .htmlDescription("<p>Transport vehicles</p>")
                        .image(trucks)
                        .build(),

                ProductLine.builder()
                        .productLine("Motorcycles")
                        .textDescription("Speed and style combined")
                        .htmlDescription("<p>Motorbikes collection</p>")
                        .image(motorcycles)
                        .build()
            ));
        }
    }
}
*/
