package ru.kampaii.services;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

public class WireMockExample {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule();

    @Test
    public void test() throws IOException {

        String input = "test123";

        wireMockRule.stubFor(get(urlEqualTo("/test"))
                .willReturn(aResponse().withBody(input)));

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://localhost:8080/test");
        HttpResponse response = httpClient.execute(get);

        assertEquals(input,convertHttpResponseToString(response));

    }

    private static String convertHttpResponseToString(HttpResponse httpResponse) throws IOException {
        InputStream inputStream = httpResponse.getEntity().getContent();
        return convertInputStreamToString(inputStream);
    }

    private static String convertInputStreamToString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        String string = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return string;
    }
}
