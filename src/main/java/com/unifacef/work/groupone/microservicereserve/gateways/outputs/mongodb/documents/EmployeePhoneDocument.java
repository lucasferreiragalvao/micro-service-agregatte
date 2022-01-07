package com.unifacef.work.groupone.microservicereserve.gateways.outputs.mongodb.documents;

import com.unifacef.work.groupone.microservicereserve.domains.EmployeePhone;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeePhoneDocument {
    private String ddi;
    private String ddd;
    private String phoneNumber;

    public EmployeePhoneDocument (final EmployeePhone phone){
        this.ddi = phone.getDdi();
        this.ddd = phone.getDdd();
        this.phoneNumber = phone.getPhoneNumber();
    }

    public EmployeePhone toDomain(){
        return EmployeePhone.builder()
                .ddi(this.ddi)
                .ddd(this.ddd)
                .phoneNumber(this.phoneNumber)
                .build();
    }
}
