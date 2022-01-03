package com.unifacef.work.groupone.microservicereserve.gateways.outputs;

import com.unifacef.work.groupone.microservicereserve.domains.Reserve;

import java.util.Optional;

public interface ReserveDataGateway {

    Reserve save(Reserve reserve);

    Optional<Reserve> findByCode(String code);

}
