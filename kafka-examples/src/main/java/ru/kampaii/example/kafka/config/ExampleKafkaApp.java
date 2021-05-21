package ru.kampaii.example.kafka.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.kampaii.example.kafka")
public class ExampleKafkaApp {

    public static void main(String[] args) {
        SpringApplication.run(ExampleKafkaApp.class);
    }
}
