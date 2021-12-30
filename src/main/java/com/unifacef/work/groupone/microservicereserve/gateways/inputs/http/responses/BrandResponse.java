package com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.responses;

import com.unifacef.work.groupone.microservicereserve.domains.Brand;
import lombok.Data;

import java.io.Serializable;

@Data
public class BrandResponse implements Serializable {
    private static final long serialVersionUID = 9189520552888285500L;

    private Boolean imported;
    private String name;

    public BrandResponse(final Brand brand){
        this.imported = brand.getImported();
        this.name = brand.getName();
    }
}
