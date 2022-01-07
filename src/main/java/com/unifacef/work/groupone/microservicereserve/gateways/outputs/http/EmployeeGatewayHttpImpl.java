package com.unifacef.work.groupone.microservicereserve.gateways.outputs.http;

import com.unifacef.work.groupone.microservicereserve.gateways.outputs.EmployeeGateway;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.http.resources.EmployeeResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmployeeGatewayHttpImpl implements EmployeeGateway {

    private final EmployeeFeignIntegration employeeFeignIntegration;

    @Override
    public EmployeeResource findByCode(String code) {
        log.info("Find employee code: {}", code);
        return employeeFeignIntegration.findByCode(code);
    }
}
