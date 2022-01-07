package com.unifacef.work.groupone.microservicereserve.gateways.outputs.mongodb.documents;

import com.unifacef.work.groupone.microservicereserve.domains.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDocument {
    private String code;
    private String name;
    private String cpf;
    private String function;
    private String status;
    private List<EmployeeAddressDocument> addresses;
    private List<EmployeePhoneDocument> phones;

    public EmployeeDocument (final Employee employee){
        this.code = employee.getCode();
        this.name = employee.getName();
        this.cpf = employee.getCpf();
        this.function = employee.getFunction();
        this.status = employee.getStatus();
        this.addresses = employee.getAddresses().stream().map(EmployeeAddressDocument::new).collect(Collectors.toList());
        this.phones = employee.getPhones().stream().map(EmployeePhoneDocument::new).collect(Collectors.toList());
    }

    public Employee toDomain(){
        return Employee.builder()
                .code(this.code)
                .name(this.name)
                .cpf(this.cpf)
                .function(this.function)
                .addresses(this.addresses.stream().map(address -> address.toDomain()).collect(Collectors.toList()))
                .phones(this.phones.stream().map(phone -> phone.toDomain()).collect(Collectors.toList()))
                .build();
    }
}
