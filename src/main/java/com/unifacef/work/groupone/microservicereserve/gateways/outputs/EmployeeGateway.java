package com.unifacef.work.groupone.microservicereserve.gateways.outputs;

import com.unifacef.work.groupone.microservicereserve.gateways.outputs.http.resources.EmployeeResource;

public interface EmployeeGateway {

    EmployeeResource findByCode(String code);
}
