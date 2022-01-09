package com.unifacef.work.groupone.microservicereserve.usecases;

import com.unifacef.work.groupone.microservicereserve.domains.Reserve;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.ReserveDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindReserve {

    private final ReserveDataGateway reserveDataGateway;

    public Page<Reserve> execute(final Pageable pageable) {
        log.info("Find reserves . Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
        return reserveDataGateway.findByPage(pageable);
    }

}
