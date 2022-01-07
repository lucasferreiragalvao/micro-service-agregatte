package com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.requests;

import com.unifacef.work.groupone.microservicereserve.domains.Reserve;
import com.unifacef.work.groupone.microservicereserve.domains.Status;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class PatchFinishedReserveRequest implements Serializable {
    private static final long serialVersionUID = 3875925051912991191L;

    @ApiModelProperty(position = 1)
    private Long finalOdomenter;

    @ApiModelProperty(position = 2)
    @NotNull(message = "{required.field}")
    private TankStatusReserveRequest tankStatusFinal;

    public Reserve toDomain(final String code){
        return Reserve.builder()
                .code(code)
                .status(Status.FINISHED.getDescription())
                .finalOdomenter(this.finalOdomenter)
                .tankStatusFinal(this.tankStatusFinal.getDescription())
                .build();
    }
}
