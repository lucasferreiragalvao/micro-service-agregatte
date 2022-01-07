package com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.responses;

import com.unifacef.work.groupone.microservicereserve.domains.EmployeePhone;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeePhonesResponse  implements Serializable {
    private static final long serialVersionUID = 3009520552888285200L;

    @ApiModelProperty(position = 0)
    private String ddi;

    @ApiModelProperty(position = 1)
    private String ddd;

    @ApiModelProperty(position = 2)
    private String phoneNumber;

    public EmployeePhonesResponse(final EmployeePhone employeePhone){
        this.ddi = employeePhone.getDdi();
        this.ddd = employeePhone.getDdd();
        this.phoneNumber = employeePhone.getPhoneNumber();
    }
}
