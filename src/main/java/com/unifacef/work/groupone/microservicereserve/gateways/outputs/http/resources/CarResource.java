package com.unifacef.work.groupone.microservicereserve.gateways.outputs.http.resources;

import com.unifacef.work.groupone.microservicereserve.domains.Brand;
import com.unifacef.work.groupone.microservicereserve.domains.Car;
import com.unifacef.work.groupone.microservicereserve.domains.Classification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarResource {

    private String code;
    private int year;
    private String color;
    private ClassificationResource classification;
    private BrandResource brand;
    private String model;
    private String name;
    private String board;
    private Double tankSize;
    private Long odomenter;
    private Boolean isActive;
    private String note;

    public Car toDomain(){
        return Car.builder()
                .code(this.code)
                .year(this.year)
                .color(this.color)
                .classification(
                        Classification.builder()
                                .code(this.getClassification().getCode())
                                .name(this.getClassification().getName())
                                .price(this.getClassification().getPrice())
                                .build())
                .brand(
                        Brand.builder()
                                .imported(this.brand.getImported())
                                .name(this.brand.getName())
                                .build())
                .model(this.model)
                .name(this.name)
                .board(this.board)
                .tankSize(this.tankSize)
                .odomenter(this.odomenter)
                .isActive(this.isActive)
                .note(this.note)
                .build();
    }

}
