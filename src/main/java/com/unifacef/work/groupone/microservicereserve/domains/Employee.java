package com.unifacef.work.groupone.microservicereserve.domains;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Employee {
    private String code;
    private String name;
    private String cpf;
    private String function;
    private String status;
    private List<EmployeeAddress> addresses;
    private List<EmployeePhone> phones;

}
