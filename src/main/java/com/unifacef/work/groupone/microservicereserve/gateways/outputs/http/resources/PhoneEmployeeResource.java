package com.unifacef.work.groupone.microservicereserve.gateways.outputs.http.resources;

import com.unifacef.work.groupone.microservicereserve.domains.EmployeeAddress;
import com.unifacef.work.groupone.microservicereserve.domains.EmployeePhone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneEmployeeResource {

    private String ddi;
    private String ddd;
    private String phoneNumber;

    public EmployeePhone toDomain(){
        return EmployeePhone.builder()
                .ddi(this.ddi)
                .ddd(this.ddd)
                .phoneNumber(this.phoneNumber)
                .build();
    }
}
