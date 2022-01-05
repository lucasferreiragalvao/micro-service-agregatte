package com.unifacef.work.groupone.microservicereserve.domains;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Classification {
    private String code;
    private String name;
    private Double price;

}
