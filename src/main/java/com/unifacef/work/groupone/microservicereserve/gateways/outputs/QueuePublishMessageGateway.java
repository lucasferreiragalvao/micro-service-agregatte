package com.unifacef.work.groupone.microservicereserve.gateways.outputs;

import org.springframework.amqp.core.Message;

public interface QueuePublishMessageGateway {

    void execute(Message message);
}
