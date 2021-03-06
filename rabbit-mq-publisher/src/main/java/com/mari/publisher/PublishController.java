package com.mari.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {
    private static final String EXCHANGE_NAME = "sample.exchange";

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/sample/queue")
    public String samplePublish(String message) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "sample.mari",
                "Message : "+ message);
        return "message sending!";
    }

}
