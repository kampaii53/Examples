package ru.kampaii.example.kafka.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
@SpringBootApplication(scanBasePackages = "ru.kampaii.example.kafka")
public class ExampleKafkaApp {

    public static void main(String[] args) {
        SpringApplication.run(ExampleKafkaApp.class);
    }

    @KafkaListener(topics="msg")
    public void msgListener(String msg){
        System.out.println(msg);
    }

}
