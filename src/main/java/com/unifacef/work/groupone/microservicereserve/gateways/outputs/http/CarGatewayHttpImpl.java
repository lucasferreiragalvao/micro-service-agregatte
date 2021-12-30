package com.unifacef.work.groupone.microservicereserve.gateways.outputs.http;

import com.unifacef.work.groupone.microservicereserve.gateways.outputs.CarGateway;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.http.resources.CarResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CarGatewayHttpImpl implements CarGateway {
    private final CarFeignIntegration carFeignIntegration;

    @Override
    public CarResource findByCode(String code) {
        log.info("Find car code: {}", code);
        return carFeignIntegration.findByCode(code);
    }
}
