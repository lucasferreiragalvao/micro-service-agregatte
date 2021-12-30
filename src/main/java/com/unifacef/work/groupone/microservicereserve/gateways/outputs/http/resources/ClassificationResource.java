package com.unifacef.work.groupone.microservicereserve.gateways.outputs.http.resources;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum ClassificationResource {
    SUV("suv"),
    COMPACTO("compacto"),
    LUXO("luxo");

    private String description;

}
