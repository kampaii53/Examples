package ru.kampaii.example.feign.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "client", url = "http://localhost:8080")
public interface ExampleAppClient {

    @GetMapping("/test")
    String getTest();
}
