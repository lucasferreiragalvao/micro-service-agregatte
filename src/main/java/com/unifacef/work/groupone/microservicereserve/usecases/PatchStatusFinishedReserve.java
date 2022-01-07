package com.unifacef.work.groupone.microservicereserve.usecases;

import com.unifacef.work.groupone.microservicereserve.domains.Reserve;
import com.unifacef.work.groupone.microservicereserve.domains.Status;
import com.unifacef.work.groupone.microservicereserve.exceptions.MessageKey;
import com.unifacef.work.groupone.microservicereserve.exceptions.NotFoundException;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.QueuePublishMessageGateway;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.ReserveDataGateway;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.rabbitmq.message.ConvertMessage;
import com.unifacef.work.groupone.microservicereserve.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PatchStatusFinishedReserve {
    private final ReserveDataGateway reserveDataGateway;
    private final MessageUtils messageUtils;
    private final QueuePublishMessageGateway queuePublishMessageGateway;

    public Reserve execute(final Reserve reserve){;
        log.info("Finished reserve : {}",reserve.getCode());
        Reserve oldReserve = reserveDataGateway.findByCode(reserve.getCode())
                .orElseThrow(() -> new NotFoundException(messageUtils.getMessage(MessageKey.RESERVE_NOT_FOUND,reserve.getCode())));
        validate(oldReserve);
        oldReserve.setStatus(reserve.getStatus());

        oldReserve.setTankStatusFinal(reserve.getTankStatusFinal());

        if(reserve.getFinalOdomenter() != null){
            validateFinalOdometerGreaterThanStartOdometer(reserve.getFinalOdomenter(),oldReserve.getStartOdomenter());
            oldReserve.setFinalOdomenter(reserve.getFinalOdomenter());
        }
        Reserve reserveSaved = reserveDataGateway.save(oldReserve);
        queuePublishMessageGateway.execute(
                ConvertMessage.convertMessageCar(reserveSaved.getCar().getCode(),reserveSaved.getFinalOdomenter(), reserveSaved.getTankStatusFinal())
        );
        return reserveSaved;
    }
    private void validate(Reserve reserve){
        validStatus(reserve);
    }

    private void validStatus(Reserve reserve){
        if(reserve.getStatus().equals(Status.PENDING.getDescription())){
            throw new IllegalArgumentException(messageUtils.getMessage(MessageKey.RESERVE_NOT_FINISHED_BECAUSE_STATUS_IN_PROGRESS,reserve.getCode()));
        }
        if(reserve.getStatus().equals(Status.FINISHED.getDescription())){
            throw new IllegalArgumentException(messageUtils.getMessage(MessageKey.RESERVE_IS_ALREADY_FINISHED,reserve.getCode()));
        }
    }

    private void validateFinalOdometerGreaterThanStartOdometer(Long finalOdomenter,Long startOdomenter){
        if(finalOdomenter < startOdomenter){
            throw new IllegalArgumentException(messageUtils.getMessage(MessageKey.RESERVE_FINAL_ODOMETER_LESS_THAN_START_ODOMETER,startOdomenter));
        }
    }

    private void validTankStatus(Reserve reserve) {

    }

}
