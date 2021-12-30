package com.unifacef.work.groupone.microservicereserve.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageKey {
    CAR_ALREADY_RENTED("car.already.rented");

    private String key;
}
