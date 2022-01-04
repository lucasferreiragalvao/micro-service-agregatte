package com.unifacef.work.groupone.microservicereserve.gateways.outputs.rabbitmq;

import com.unifacef.work.groupone.microservicereserve.gateways.outputs.QueuePublishMessageGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QueuePublishMessageGatewayImpl implements QueuePublishMessageGateway {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${application.rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${application.rabbitmq.routing.key}")
    private String routingKey;

    @Override
    public void execute(Message message) {
        try {
            this.rabbitTemplate.convertAndSend(
                    this.exchangeName,
                    this.routingKey,
                    message
            );
        }catch (AmqpException ex){
            throw ex;
        }
    }
}
