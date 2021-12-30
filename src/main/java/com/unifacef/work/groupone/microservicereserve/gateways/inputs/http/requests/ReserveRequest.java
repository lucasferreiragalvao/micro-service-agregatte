package com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.requests;

import com.unifacef.work.groupone.microservicereserve.domains.Status;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public abstract class ReserveRequest implements Serializable {

    private static final long serialVersionUID = 3475925051912891198L;

    @ApiModelProperty(position = 1)
    @NotNull(message = "{required.field}")
    private String codeCustomer;

    @ApiModelProperty(position = 2)
    private String codeCar;

    @ApiModelProperty(position = 3)
    private LocalDateTime startDate;

    @ApiModelProperty(position = 4)
    private LocalDateTime finalDate;

    @ApiModelProperty(position = 5)
    private Status status;

}
