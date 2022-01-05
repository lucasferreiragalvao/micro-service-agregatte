package com.unifacef.work.groupone.microservicereserve.gateways.outputs.http;

import com.unifacef.work.groupone.microservicereserve.gateways.outputs.CustomerGateway;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.http.resources.CustomerResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerGatewayHttpImpl implements CustomerGateway {

    private final CustomerFeignIntegration customerFeignIntegration;

    @Override
    public CustomerResource findByCode(String code) {
        log.info("Find customer code: {}", code);
        return customerFeignIntegration.findByCode(code);
    }
}
