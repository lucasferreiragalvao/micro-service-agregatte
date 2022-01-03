package com.unifacef.work.groupone.microservicereserve.gateways.outputs.mongodb.documents;

import com.unifacef.work.groupone.microservicereserve.domains.Car;
import com.unifacef.work.groupone.microservicereserve.domains.Classification;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarDocument {
    private String id;
    private int year;
    private String color;
    private Classification classification;
    private BrandDocument brand;
    private String model;
    private String name;
    private String board;
    private Double tankSize;
    private Long odomenter;
    private Boolean isActive;
    private String note;

    public CarDocument(final Car car){
        this.id = car.getCode();
        this.year = car.getYear();
        this.color = car.getColor();
        this.classification = Classification.valueOf(car.getClassification().toString());
        this.brand = new BrandDocument(car.getBrand());
        this.model = car.getModel();
        this.name = car.getName();
        this.board = car.getBoard();
        this.tankSize = car.getTankSize();
        this.odomenter = car.getOdomenter();
        this.isActive = car.getIsActive();
        this.note = car.getNote();
    }
}
