package ru.kampaii.example.kafka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class ExampleKafkaController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("send")
    public void sendOrder(String msgId, String msg){
        kafkaTemplate.send("msg", msgId, msg);
    }
}
