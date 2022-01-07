package com.unifacef.work.groupone.microservicereserve.domains;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeePhone {

    private String ddi;
    private String ddd;
    private String phoneNumber;
}
