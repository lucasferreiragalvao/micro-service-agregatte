package com.unifacef.work.groupone.microservicereserve.usecases;

import com.unifacef.work.groupone.microservicereserve.domains.Car;
import com.unifacef.work.groupone.microservicereserve.domains.Reserve;
import com.unifacef.work.groupone.microservicereserve.domains.Status;
import com.unifacef.work.groupone.microservicereserve.exceptions.MessageKey;
import com.unifacef.work.groupone.microservicereserve.exceptions.NotFoundException;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.CarGateway;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.ReserveDataGateway;
import com.unifacef.work.groupone.microservicereserve.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PatchStatusInProgressReserve {

    private final ReserveDataGateway reserveDataGateway;
    private final MessageUtils messageUtils;
    private final CarGateway carGateway;


    public Reserve execute(final String code){
        log.info("In Progress reserve : {}", code);
        Reserve oldReserve = reserveDataGateway.findByCode(code)
                .orElseThrow(() -> new NotFoundException(messageUtils.getMessage(MessageKey.RESERVE_NOT_FOUND,code)));
        validate(oldReserve);
        Car car = carGateway.findByCode(oldReserve.getCar().getCode()).toDomain();
        oldReserve.setStartOdomenter(car.getOdomenter());
        oldReserve.setStatus(Status.IN_PROGRESS);
        log.info("Patch reserve : {}", code);
        return reserveDataGateway.save(oldReserve);
    }

    private void validate(Reserve reserve){
        validStatus(reserve);
    }

    private void validStatus(Reserve reserve){
        if(reserve.getStatus().equals(Status.IN_PROGRESS)){
            throw new IllegalArgumentException(messageUtils.getMessage(MessageKey.RESERVE_IS_ALREADY_IN_PROGRESS,reserve.getCode()));
        }
        if(reserve.getStatus().equals(Status.FINISHED)){
            throw new IllegalArgumentException(messageUtils.getMessage(MessageKey.RESERVE_IS_ALREADY_FINISHED,reserve.getCode()));
        }
    }
}
