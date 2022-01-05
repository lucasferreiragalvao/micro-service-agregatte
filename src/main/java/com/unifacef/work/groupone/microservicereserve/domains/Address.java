package com.unifacef.work.groupone.microservicereserve.domains;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String street;
    private String district;
    private String zip;
    private String city;
    private String complement;
    private String uf;
}
