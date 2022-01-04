package com.unifacef.work.groupone.microservicereserve.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageKey {
    RESERVE_NOT_FOUND("reserve.not.found"),
    CAR_ALREADY_RENTED("car.already.rented"),
    RESERVE_FINAL_ODOMETER_LESS_THAN_START_ODOMETER("reserve.final.odometer.less.than.start.odometer"),
    RESERVE_IS_ALREADY_IN_PROGRESS("reserve.is.already.in.progress"),
    RESERVE_IS_ALREADY_FINISHED("reserve.is.already.finished");

    private String key;
}
