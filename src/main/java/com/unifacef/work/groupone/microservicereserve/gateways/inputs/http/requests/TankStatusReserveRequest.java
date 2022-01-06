package com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TankStatusReserveRequest {

    EMPTY("EMPTY"),
    A_QUARTER("A QUARTER"),
    HALF_FULL("HAL FULL"),
    THREE_QUARTERS("THREE QUARTERS"),
    FULL("FULL");

    private String description;
}
