package com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.responses;

import com.unifacef.work.groupone.microservicereserve.domains.Employee;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class EmployeeResponse implements Serializable {
    private static final long serialVersionUID = 3189520552888285200L;

    @ApiModelProperty(position = 0)
    private String code;

    @ApiModelProperty(position = 1)
    private String name;

    @ApiModelProperty(position = 3)
    private String cpf;

    @ApiModelProperty(position = 4)
    private String function;

    @ApiModelProperty(position = 5)
    private String status;

    @ApiModelProperty(position = 6)
    private List<EmployeeAddressResponse> addresses;

    @ApiModelProperty(position = 7)
    private List<EmployeePhonesResponse> phones;

    public EmployeeResponse(final Employee employee){
        this.code = employee.getCode();
        this.name = employee.getName();
        this.cpf = employee.getCpf();
        this.function = employee.getFunction();
        this.status = employee.getStatus();
        this.addresses = employee.getAddresses().stream().map(EmployeeAddressResponse::new).collect(Collectors.toList());
        this.phones = employee.getPhones().stream().map(EmployeePhonesResponse::new).collect(Collectors.toList());
    }
}
