package com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.responses;

import com.unifacef.work.groupone.microservicereserve.domains.EmployeeAddress;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeAddressResponse implements Serializable {
    private static final long serialVersionUID = 3009520552888285200L;

    @ApiModelProperty(position = 0)
    private String state;

    @ApiModelProperty(position = 1)
    private String city;

    @ApiModelProperty(position = 2)
    private String neighborhood;

    @ApiModelProperty(position = 3)
    private String streetName;

    @ApiModelProperty(position = 4)
    private String streetNumber;

    @ApiModelProperty(position = 5)
    private String complement;

    public EmployeeAddressResponse(final EmployeeAddress employeeAddress){
       this.state = employeeAddress.getState();
       this.city = employeeAddress.getCity();
       this.neighborhood = employeeAddress.getNeighborhood();
       this.streetName = employeeAddress.getStreetName();
       this.streetNumber = employeeAddress.getStreetNumber();
       this.complement = employeeAddress.getComplement();
    }
}
