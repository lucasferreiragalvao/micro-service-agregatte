package com.unifacef.work.groupone.microservicereserve.gateways.outputs;

import com.unifacef.work.groupone.microservicereserve.gateways.outputs.http.resources.CarResource;

public interface CarGateway {

    CarResource findByCode(String code);
}
