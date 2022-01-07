package com.unifacef.work.groupone.microservicereserve.gateways.outputs.http.resources;

import com.unifacef.work.groupone.microservicereserve.domains.EmployeeAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressEmployeeResource {
    private String state;
    private String city;
    private String neighborhood;
    private String streetName;
    private String streetNumber;
    private String complement;

    public EmployeeAddress toDomain(){
        return EmployeeAddress.builder()
                .state(this.state)
                .city(this.city)
                .neighborhood(this.neighborhood)
                .streetName(this.streetName)
                .streetNumber(this.streetNumber)
                .complement(this.complement)
                .build();
    }
}
