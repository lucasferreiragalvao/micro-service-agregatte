package com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.responses;

import com.unifacef.work.groupone.microservicereserve.domains.Customer;
import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerResponse implements Serializable {

    private String code;

    public CustomerResponse(final Customer customer){
        this.code = customer.getCode();
    }
}
