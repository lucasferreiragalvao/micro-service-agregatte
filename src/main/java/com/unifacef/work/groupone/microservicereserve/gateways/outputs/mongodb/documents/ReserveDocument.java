package com.unifacef.work.groupone.microservicereserve.gateways.outputs.mongodb.documents;

import com.unifacef.work.groupone.microservicereserve.domains.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@Document("reserves")
public class ReserveDocument {
    @Id
    private String id;
    private CustomerDocument customer;
    private CarDocument car;
    private EmployeeDocument employee;
    private LocalDateTime startDate;
    private LocalDateTime finalDate;
    private Long startOdomenter;
    private Long finalOdomenter;
    private String status;
    private String tankStatusStart;
    private String tankStatusFinal;
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    public ReserveDocument(final Reserve reserve){
        this.id = reserve.getCode();
        this.customer = new CustomerDocument(reserve.getCustomer());
        this.car = new CarDocument(reserve.getCar());
        this.employee = Objects.isNull(reserve.getEmployee()) ? null : new EmployeeDocument(reserve.getEmployee());
        this.startDate = reserve.getStartDate();
        this.finalDate = reserve.getFinalDate();
        this.status = reserve.getStatus();
        this.startOdomenter = reserve.getStartOdomenter();
        this.finalOdomenter = reserve.getFinalOdomenter();
        this.tankStatusStart = reserve.getTankStatusStart();
        this.tankStatusFinal = reserve.getTankStatusFinal();
        this.createdAt = reserve.getCreatedDate();
        this.lastModifiedDate = reserve.getLastModifiedDate();
    }

    public Reserve toDomain(){
        return Reserve.builder()
                .code(this.id)
                .customer(this.customer.toDomain())
                .car(this.car.toDomain())
                .employee(Objects.isNull(this.employee) ? null: this.employee.toDomain())
                .startDate(this.startDate)
                .finalDate(this.finalDate)
                .startOdomenter(this.startOdomenter)
                .finalOdomenter(this.finalOdomenter)
                .tankStatusStart(this.tankStatusStart)
                .tankStatusFinal(this.tankStatusFinal)
                .status(this.status)
                .build();
    }
}
