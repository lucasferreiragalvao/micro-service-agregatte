package com.unifacef.work.groupone.microservicereserve.domains;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Customer {
    private String code;
    private String name;
    private String telephone;
    private String driverLincenseNumber;
    private List<Address> address;
    private String cpf;
    private String birthday;
    private String email;
}
