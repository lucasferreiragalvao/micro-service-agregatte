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
    private Status status;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
