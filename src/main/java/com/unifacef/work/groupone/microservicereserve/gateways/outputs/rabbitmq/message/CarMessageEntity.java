package com.unifacef.work.groupone.microservicereserve.gateways.outputs.rabbitmq.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarMessageEntity {
    private String code;
    private Long odomenter;
    private String tankStatus;
}
