package com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.requests;

import com.unifacef.work.groupone.microservicereserve.domains.Car;
import com.unifacef.work.groupone.microservicereserve.domains.Customer;
import com.unifacef.work.groupone.microservicereserve.domains.Reserve;

public class CreateReserveRequest extends ReserveRequest{

    private static final long serialVersionUID = 8743997776881612717L;

    public Reserve toDomain(){
        return Reserve.builder()
                .customer(Customer.builder().code(super.getCodeCustomer()).build())
                .car(Car.builder().code(super.getCodeCar()).build())
                .startDate(super.getStartDate())
                .finalDate(super.getFinalDate())
                .status(super.getStatus())
                .build();
    }
}
