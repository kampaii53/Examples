package ru.kampaii.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kampaii.example.services.ExampleAppService;

@RestController
public class ExampleController {

    private final ExampleAppService exampleAppService;

    public ExampleController(ExampleAppService exampleAppService) {
        this.exampleAppService = exampleAppService;
    }

    @GetMapping("/test")
    public String test(){
        return exampleAppService.requestTest();
    }
}
