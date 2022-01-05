package com.unifacef.work.groupone.microservicereserve.gateways.outputs;

import com.unifacef.work.groupone.microservicereserve.gateways.outputs.http.resources.CustomerResource;

public interface CustomerGateway {

    CustomerResource findByCode(String code);
}
