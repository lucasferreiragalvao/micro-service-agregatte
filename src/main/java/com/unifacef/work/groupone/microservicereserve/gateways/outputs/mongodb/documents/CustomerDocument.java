package com.unifacef.work.groupone.microservicereserve.gateways.outputs.mongodb.documents;

import com.unifacef.work.groupone.microservicereserve.domains.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CustomerDocument {
    private String code;
    private String name;
    private String telephone;
    private String driverLincenseNumber;
    private List<AddressDocument> address;
    private String cpf;
    private String birthday;
    private String email;

    public CustomerDocument(final Customer customer){
        this.code = customer.getCode();
        this.name = customer.getName();
        this.telephone = customer.getTelephone();
        this.driverLincenseNumber = customer.getDriverLincenseNumber();
        this.address = customer.getAddress().stream().map(AddressDocument::new).collect(Collectors.toList());
        this.cpf = customer.getCpf();
        this.birthday = customer.getBirthday();
        this.email = customer.getEmail();
    }

    public Customer toDomain(){
        return Customer.builder()
                .code(this.code)
                .name(this.name)
                .telephone(this.telephone)
                .driverLincenseNumber(this.driverLincenseNumber)
                .address(this.address.stream().map(address -> address.toDomain()).collect(Collectors.toList()))
                .cpf(this.cpf)
                .birthday(this.birthday)
                .email(this.email)
                .build();
    }
}
