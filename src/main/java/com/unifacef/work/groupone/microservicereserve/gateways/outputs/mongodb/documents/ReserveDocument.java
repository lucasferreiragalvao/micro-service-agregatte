package com.unifacef.work.groupone.microservicereserve.gateways.outputs.mongodb.documents;

import com.unifacef.work.groupone.microservicereserve.domains.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@Document("reserves")
public class ReserveDocument {
    @Id
    private String id;
    private CustomerDocument customer;
    private CarDocument car;
    private LocalDateTime startDate;
    private LocalDateTime finalDate;
    private Status status;
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    public ReserveDocument(final Reserve reserve){
        this.id = reserve.getCode();
        this.customer = new CustomerDocument(reserve.getCustomer());
        this.car = new CarDocument(reserve.getCar());
        this.startDate = reserve.getStartDate();
        this.finalDate = reserve.getFinalDate();
        this.status = reserve.getStatus();
        this.createdAt = reserve.getCreatedDate();
        this.lastModifiedDate = reserve.getLastModifiedDate();
    }

    public Reserve toDomain(){
        return Reserve.builder()
                .code(this.id)
                .customer(Customer.builder().code(customer.getCode()).build())
                .car(Car.builder().code(car.getId()).board(car.getBoard())
                        .code(car.getId())
                        .year(car.getYear())
                        .color(car.getColor())
                        .classification(car.getClassification())
                        .brand(Brand.builder().imported(car.getBrand().getImported()).name(car.getBrand().getName()).build())
                        .model(car.getModel())
                        .name(car.getName())
                        .tankSize(car.getTankSize())
                        .isActive(car.getIsActive())
                        .note(car.getNote())
                        .build())
                .startDate(startDate)
                .finalDate(finalDate)
                .status(status)
                .build();
    }
}
