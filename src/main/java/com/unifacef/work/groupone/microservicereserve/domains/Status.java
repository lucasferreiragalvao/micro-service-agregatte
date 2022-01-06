package com.unifacef.work.groupone.microservicereserve.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    PENDING("PENDING"),
    IN_PROGRESS("IN PROGRESS"),
    FINISHED("FINISHED");

    private String description;
}
