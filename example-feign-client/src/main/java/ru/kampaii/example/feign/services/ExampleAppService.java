package ru.kampaii.example.feign.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.kampaii.example.feign.clients.ExampleAppClient;

@Service
public class ExampleAppService {

    private static final Logger log = LoggerFactory.getLogger(ExampleAppService.class);

    private final ExampleAppClient exampleAppClient;

    public ExampleAppService(ExampleAppClient exampleAppClient) {
        this.exampleAppClient = exampleAppClient;
    }

    public String requestTest() {
        String result = exampleAppClient.getTest();

        log.debug("result is {}", result);
        return result;
    }

}
