package com.unifacef.work.groupone.microservicereserve.gateways.outputs.rabbitmq.message;


import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;

import java.nio.charset.StandardCharsets;

public class ConvertMessage {

    public static Message convertMessageCar(String code, Long finalOdomenter){
        return new Message(
                new Gson().toJson(new CarMessageEntity(code,finalOdomenter)).getBytes(StandardCharsets.UTF_8),
                new MessageProperties()
        );
    }
}
