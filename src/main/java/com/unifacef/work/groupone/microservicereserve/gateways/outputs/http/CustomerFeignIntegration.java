package com.unifacef.work.groupone.microservicereserve.gateways.outputs.http;

import com.unifacef.work.groupone.microservicereserve.configurations.feign.FeignConfiguration;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.http.resources.CustomerResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "customer", url = "${integration.customer.url}", configuration = FeignConfiguration.class)
public interface CustomerFeignIntegration {
    @RequestMapping(method = RequestMethod.GET,value = "/api/v1/customers/{code}")
    CustomerResource findByCode(@PathVariable("code") final String code);
}
