package com.unifacef.work.groupone.microservicereserve.gateways.outputs.http;

import com.unifacef.work.groupone.microservicereserve.configurations.feign.FeignConfiguration;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.http.resources.CarResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "car", url = "${integration.car.url}", configuration = FeignConfiguration.class)
public interface CarFeignIntegration {

    @RequestMapping(method = RequestMethod.GET,value = "/api/v1/cars/{code}")
    CarResource findByCode(@PathVariable("code") final String code);
}
