package com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.responses;

import com.unifacef.work.groupone.microservicereserve.domains.Customer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CustomerResponse implements Serializable {

    @ApiModelProperty(position = 1)
    private String code;

    @ApiModelProperty(position = 2)
    private String name;

    @ApiModelProperty(position = 3)
    private String telephone;

    @ApiModelProperty(position = 4)
    private String driverLincenseNumber;

    @ApiModelProperty(position = 5)
    private List<AddressResponse> address;

    @ApiModelProperty(position = 6)
    private String cpf;

    @ApiModelProperty(position = 7)
    private String birthday;

    @ApiModelProperty(position = 8)
    private String email;

    public CustomerResponse(final Customer customer){

        this.code = customer.getCode();
        this.name = customer.getName();
        this.telephone = customer.getTelephone();
        this.driverLincenseNumber = customer.getDriverLincenseNumber();
        this.address = customer.getAddress().stream().map(AddressResponse::new).collect(Collectors.toList());
        this.cpf = customer.getCpf();
        this.birthday = customer.getBirthday();
        this.email = customer.getEmail();
    }
}
