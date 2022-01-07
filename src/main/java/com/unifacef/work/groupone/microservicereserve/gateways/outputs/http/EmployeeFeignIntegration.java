package com.unifacef.work.groupone.microservicereserve.gateways.outputs.http;

import com.unifacef.work.groupone.microservicereserve.configurations.feign.FeignConfiguration;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.http.resources.EmployeeResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "employee", url = "${integration.employee.url}", configuration = FeignConfiguration.class)
public interface EmployeeFeignIntegration {
    @RequestMapping(method = RequestMethod.GET,value = "/api/v1/employees/{code}")
    EmployeeResource findByCode(@PathVariable("code") final String code);
}
