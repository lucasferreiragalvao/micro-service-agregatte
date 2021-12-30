package com.unifacef.work.groupone.microservicereserve.gateways.outputs.http.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandResource {
    private Boolean imported;
    private String name;
}
