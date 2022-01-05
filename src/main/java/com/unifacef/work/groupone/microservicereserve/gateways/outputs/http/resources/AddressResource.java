package com.unifacef.work.groupone.microservicereserve.gateways.outputs.http.resources;

import com.unifacef.work.groupone.microservicereserve.domains.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResource {
    private String street;
    private String district;
    private String zip;
    private String city;
    private String complement;
    private String uf;

    public Address toDomain(){
        return Address.builder()
                .street(this.street)
                .district(this.district)
                .zip(this.zip)
                .city(this.city)
                .complement(this.complement)
                .uf(this.uf)
                .build();
    }

}
