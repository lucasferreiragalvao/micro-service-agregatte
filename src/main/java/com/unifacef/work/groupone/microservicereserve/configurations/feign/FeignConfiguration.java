package com.unifacef.work.groupone.microservicereserve.configurations.feign;

import feign.Request;
import feign.Retryer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Configuration
@EnableFeignClients(basePackages = {"com.unifacef.work.groupone.microservicereserve.gateways.outputs.http"})
public class FeignConfiguration {

    @Value("${feign.connectionTimeout:60000}")
    private int feignConnectionTimeout;

    @Value("${feign.readTimeout:60000}")
    private int feignReadTimeout;

    @Bean
    public Retryer retry() {
        return new Retryer.Default();
    }

    @Bean
    public Request.Options requestOptions() {
        return new Request.Options(
                feignConnectionTimeout, MILLISECONDS, feignReadTimeout, MILLISECONDS, true);
    }


}
