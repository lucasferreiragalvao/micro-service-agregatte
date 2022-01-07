package com.unifacef.work.groupone.microservicereserve.gateways.outputs.mongodb.documents;

import com.unifacef.work.groupone.microservicereserve.domains.EmployeeAddress;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeAddressDocument {
    private String state;
    private String city;
    private String neighborhood;
    private String streetName;
    private String streetNumber;
    private String complement;

    public EmployeeAddressDocument (final EmployeeAddress address){
        this.state = address.getState();
        this.city = address.getCity();
        this.neighborhood = address.getNeighborhood();
        this.streetName = address.getStreetName();
        this.streetNumber = address.getNeighborhood();
        this.complement = address.getComplement();
    }

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
