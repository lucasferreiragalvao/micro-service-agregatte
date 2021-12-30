package com.unifacef.work.groupone.microservicereserve.domains;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Classification {
    SUV("suv"),
    COMPACTO("compacto"),
    LUXO("luxo");

    private String description;

}
