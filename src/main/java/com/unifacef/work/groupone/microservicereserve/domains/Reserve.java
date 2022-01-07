package com.unifacef.work.groupone.microservicereserve.domains;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Reserve {
    private String code;
    private Customer customer;
    private Car car;
    private LocalDateTime startDate;
    private LocalDateTime finalDate;
    private String status;
    private Long startOdomenter;
    private Long finalOdomenter;
    private Employee employee;
    private String tankStatusStart;
    private String tankStatusFinal;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
