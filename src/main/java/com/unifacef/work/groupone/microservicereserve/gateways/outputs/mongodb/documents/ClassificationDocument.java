package com.unifacef.work.groupone.microservicereserve.gateways.outputs.mongodb.documents;

import com.unifacef.work.groupone.microservicereserve.domains.Brand;
import com.unifacef.work.groupone.microservicereserve.domains.Classification;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClassificationDocument {

    private String id;
    private String name;
    private Double price;

    public ClassificationDocument(final Classification classification){
        this.id = classification.getCode();
        this.name = classification.getName();
        this.price = classification.getPrice();
    }

    public Classification toDomain(){
        return Classification.builder()
                .code(this.id)
                .name(this.name)
                .price(this.price)
                .build();
    }
}
