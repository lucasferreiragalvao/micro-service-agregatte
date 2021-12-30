package com.unifacef.work.groupone.microservicereserve.domains;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status {
    PENDING("PENDING"),
    IN_PROGRESS("IN PROGRESS"),
    FINISHED("FINISHED");

    private String description;
}
