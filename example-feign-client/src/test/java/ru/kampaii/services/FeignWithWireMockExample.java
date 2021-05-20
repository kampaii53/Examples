package ru.kampaii.services;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.kampaii.config.FeignConfiguration;
import ru.kampaii.example.clients.ExampleAppClient;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FeignConfiguration.class)
public class FeignWithWireMockExample {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule();

    @Autowired
    private ExampleAppClient feignClient;

    @Test
    public void test() throws IOException {

        String input = "test123";

        wireMockRule.stubFor(get(urlEqualTo("/test"))
                .willReturn(aResponse().withBody(input)));

        assertEquals(input,feignClient.getTest());
    }
}
