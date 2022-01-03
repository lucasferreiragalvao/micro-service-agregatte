package com.unifacef.work.groupone.microservicereserve.usecases;

import com.unifacef.work.groupone.microservicereserve.domains.Car;
import com.unifacef.work.groupone.microservicereserve.domains.Reserve;
import com.unifacef.work.groupone.microservicereserve.exceptions.MessageKey;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.CarGateway;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.ReserveDataGateway;
import com.unifacef.work.groupone.microservicereserve.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateReserve {

    private final ReserveDataGateway reserveDataGateway;
    private final CarGateway carGateway;
    private final MessageUtils messageUtils;

    public Reserve execute(final Reserve reserve){
        Car car = carGateway.findByCode(reserve.getCar().getCode()).toDomain();
        validate(car);
        reserve.setStartOdomenter(car.getOdomenter());
        reserve.setCar(car);
        log.info("Create reserve");
        Reserve saved = reserveDataGateway.save(reserve);
        return saved;
    }

    private void validate(Car car){
        log.info("Validate Reserve");
        availableCars(car);
    }

    private void availableCars(Car car){
        if(!car.getIsActive()){
            throw new IllegalArgumentException(messageUtils.getMessage(MessageKey.CAR_ALREADY_RENTED,car.getCode()));
        }
    }


}
