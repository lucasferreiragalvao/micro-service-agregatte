package com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.requests;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TankStatusReserveRequest {

    EMPTY("EMPTY"),
    A_QUARTER("A QUARTER"),
    HALF_FULL("HAL FULL"),
    THREE_QUARTERS("THREE QUARTERS"),
    FULL("FULL");

    private String key;
}
