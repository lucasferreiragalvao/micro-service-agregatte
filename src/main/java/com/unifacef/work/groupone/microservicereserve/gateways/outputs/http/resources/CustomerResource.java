package com.unifacef.work.groupone.microservicereserve.gateways.outputs.http.resources;

import com.unifacef.work.groupone.microservicereserve.domains.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResource {
    private String id;
    private String name;
    private String telephone;
    private String driverLincenseNumber;
    private List<AddressResource> addresses;
    private String cpf;
    private String birthday;
    private String email;

    public Customer toDomain(){
        return Customer.builder()
                .code(this.id)
                .name(this.name)
                .telephone(this.telephone)
                .driverLincenseNumber(this.driverLincenseNumber)
                .address(this.addresses.stream().map(addressResource -> addressResource.toDomain()).collect(Collectors.toList()))
                .cpf(this.cpf)
                .birthday(this.birthday)
                .email(this.email)
                .build();
    }
}
