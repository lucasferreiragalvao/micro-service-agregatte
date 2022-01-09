package com.unifacef.work.groupone.microservicereserve.usecases;

import com.unifacef.work.groupone.microservicereserve.domains.Reserve;
import com.unifacef.work.groupone.microservicereserve.exceptions.MessageKey;
import com.unifacef.work.groupone.microservicereserve.exceptions.NotFoundException;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.ReserveDataGateway;
import com.unifacef.work.groupone.microservicereserve.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindByReserveCode {

    private final ReserveDataGateway reserveDataGateway;
    private final MessageUtils messageUtils;

    public Reserve execute(final String code){
        log.info("Find reserve. Reserve code: {}", code);
        return reserveDataGateway.findByCode(code).orElseThrow(
                () -> new NotFoundException(messageUtils.getMessage(MessageKey.RESERVE_NOT_FOUND, code)));
    }

}
