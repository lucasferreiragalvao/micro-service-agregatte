package com.unifacef.work.groupone.microservicereserve.gateways.outputs.mongodb.repositories;

import com.unifacef.work.groupone.microservicereserve.gateways.outputs.mongodb.documents.ReserveDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReserveRepository extends MongoRepository<ReserveDocument,String> {
}
