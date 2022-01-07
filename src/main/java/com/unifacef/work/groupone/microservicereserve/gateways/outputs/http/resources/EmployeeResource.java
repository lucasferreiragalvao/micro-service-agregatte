package com.unifacef.work.groupone.microservicereserve.gateways.outputs.http.resources;

import com.unifacef.work.groupone.microservicereserve.domains.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResource {
    private String id;
    private String name;
    private String birthday;
    private String cpf;
    private String salary;
    private String function;
    private String status;
    private List<AddressEmployeeResource> addresses;
    private List<PhoneEmployeeResource> phones;

    public Employee toDomain(){
        return Employee.builder()
                .code(this.id)
                .name(this.name)
                .cpf(this.cpf)
                .function(this.function)
                .status(this.status)
                .addresses(this.addresses.stream().map(address -> address.toDomain()).collect(Collectors.toList()))
                .phones(this.phones.stream().map(phone -> phone.toDomain()).collect(Collectors.toList()))
                .build();
    }
}
