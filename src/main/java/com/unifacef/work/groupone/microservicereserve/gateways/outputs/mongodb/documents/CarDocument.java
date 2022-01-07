package com.unifacef.work.groupone.microservicereserve.gateways.outputs.mongodb.documents;

import com.unifacef.work.groupone.microservicereserve.domains.Car;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarDocument {
    private String id;
    private int year;
    private String color;
    private ClassificationDocument classification;
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
        this.classification = new ClassificationDocument(car.getClassification());
        this.brand = new BrandDocument(car.getBrand());
        this.model = car.getModel();
        this.name = car.getName();
        this.board = car.getBoard();
        this.tankSize = car.getTankSize();
        this.odomenter = car.getOdomenter();
        this.isActive = car.getIsActive();
        this.note = car.getNote();
    }

    public Car toDomain(){
        return Car.builder()
                .code(this.getId())
                .year(this.getYear())
                .color(this.getColor())
                .classification(this.classification.toDomain())
                .brand(this.brand.toDomain())
                .model(this.getModel())
                .name(this.getName())
                .board(this.getBoard())
                .tankSize(this.getTankSize())
                .isActive(this.getIsActive())
                .note(this.getNote())
                .build();
    }
}
