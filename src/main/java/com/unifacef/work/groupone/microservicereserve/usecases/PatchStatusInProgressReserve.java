package com.unifacef.work.groupone.microservicereserve.usecases;

import com.unifacef.work.groupone.microservicereserve.domains.Car;
import com.unifacef.work.groupone.microservicereserve.domains.Employee;
import com.unifacef.work.groupone.microservicereserve.domains.Reserve;
import com.unifacef.work.groupone.microservicereserve.domains.Status;
import com.unifacef.work.groupone.microservicereserve.exceptions.MessageKey;
import com.unifacef.work.groupone.microservicereserve.exceptions.NotFoundException;
import com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.requests.TankStatusReserveRequest;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.CarGateway;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.EmployeeGateway;
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
    private final EmployeeGateway employeeGateway;


    public Reserve execute(final Reserve reserve){
        log.info("In Progress reserve : {}", reserve.getCode());
        Reserve oldReserve = reserveDataGateway.findByCode(reserve.getCode())
                .orElseThrow(() -> new NotFoundException(messageUtils.getMessage(MessageKey.RESERVE_NOT_FOUND,reserve.getCode())));
        validate(oldReserve);
        Car car = carGateway.findByCode(oldReserve.getCar().getCode()).toDomain();
        Employee employee = employeeGateway.findByCode(reserve.getEmployee().getCode()).toDomain();
        oldReserve.setEmployee(employee);
        oldReserve.setStartOdomenter(car.getOdomenter());
        oldReserve.setStatus(Status.IN_PROGRESS.getDescription());
        oldReserve.setTankStatusStart(TankStatusReserveRequest.FULL.getDescription());
        log.info("Patch reserve : {}", code);
        return reserveDataGateway.save(oldReserve);
    }

    private void validate(Reserve reserve){
        validStatus(reserve);
    }

    private void validStatus(Reserve reserve){
        if(reserve.getStatus().equals(Status.IN_PROGRESS.getDescription())){
            throw new IllegalArgumentException(messageUtils.getMessage(MessageKey.RESERVE_IS_ALREADY_IN_PROGRESS,reserve.getCode()));
        }
        if(reserve.getStatus().equals(Status.FINISHED.getDescription())){
            throw new IllegalArgumentException(messageUtils.getMessage(MessageKey.RESERVE_IS_ALREADY_FINISHED,reserve.getCode()));
        }
    }
}
