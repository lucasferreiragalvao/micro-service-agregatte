package com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.requests;

import com.unifacef.work.groupone.microservicereserve.domains.Employee;
import com.unifacef.work.groupone.microservicereserve.domains.Reserve;
import com.unifacef.work.groupone.microservicereserve.domains.Status;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PatchInProgressReserveRequest implements Serializable {

    private static final long serialVersionUID = 4005925051912991191L;

    @ApiModelProperty(position = 1)
    private String codeEmployee;

    public Reserve toDomain(final String code){
        return Reserve.builder()
                .code(code)
                .employee(Employee.builder().code(this.codeEmployee).build())
                .build();
    }

}
