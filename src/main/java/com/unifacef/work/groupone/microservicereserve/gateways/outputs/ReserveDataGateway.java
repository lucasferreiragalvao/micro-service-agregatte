package com.unifacef.work.groupone.microservicereserve.gateways.outputs;

import com.unifacef.work.groupone.microservicereserve.domains.Reserve;

public interface ReserveDataGateway {

    Reserve save(Reserve reserve);

}
