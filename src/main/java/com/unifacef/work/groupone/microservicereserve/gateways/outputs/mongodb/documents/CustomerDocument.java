package com.unifacef.work.groupone.microservicereserve.gateways.outputs.mongodb.documents;

import com.unifacef.work.groupone.microservicereserve.domains.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDocument {
    private String code;

    public CustomerDocument(final Customer customer){
        this.code = customer.getCode();
    }

    public Customer toDomain(){
        return Customer.builder()
                .code(this.code)
                .build();
    }
}
