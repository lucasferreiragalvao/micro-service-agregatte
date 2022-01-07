package com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.responses;

import com.unifacef.work.groupone.microservicereserve.domains.Reserve;
import com.unifacef.work.groupone.microservicereserve.domains.Status;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
public class ReserveResponse implements Serializable {
    private static final long serialVersionUID = 9189520552888285200L;

    @ApiModelProperty(position = 0)
    private String code;

    @ApiModelProperty(position = 1)
    private CustomerResponse customer;

    @ApiModelProperty(position = 2)
    private CarResponse car;

    @ApiModelProperty(position = 3)
    private EmployeeResponse employee;

    @ApiModelProperty(position = 3)
    private LocalDateTime startDate;

    @ApiModelProperty(position = 4)
    private LocalDateTime finalDate;

    @ApiModelProperty(position = 5)
    private String status;

    @ApiModelProperty(position = 6)
    private String tankStatusStart;

    @ApiModelProperty(position = 7)
    private String tankStatusFinal;

    public ReserveResponse(final Reserve reserve) {
        this.code = reserve.getCode();
        this.customer = new CustomerResponse(reserve.getCustomer());
        this.car = new CarResponse(reserve.getCar());
        this.employee = Objects.isNull(reserve.getEmployee()) ? null : new EmployeeResponse(reserve.getEmployee());
        this.startDate = reserve.getStartDate();
        this.finalDate = reserve.getFinalDate();
        this.tankStatusStart = "FULL";
        this.tankStatusFinal = reserve.getTankStatusFinal();
        this.status = reserve.getStatus();
    }
}
