package com.unifacef.work.groupone.microservicereserve.gateways.outputs.mongodb;

import com.unifacef.work.groupone.microservicereserve.domains.Reserve;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.ReserveDataGateway;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.mongodb.documents.ReserveDocument;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.mongodb.repositories.ReserveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ReserveDataGatewayMongoImpl implements ReserveDataGateway {

    private final ReserveRepository reserveRepository;

    @Override
    public Reserve save(Reserve reserve) {
        if(Objects.isNull(reserve.getCreatedDate())){
            reserve.setCreatedDate(LocalDateTime.now());
        }
        return reserveRepository.save(new ReserveDocument(reserve)).toDomain();
    }
}
