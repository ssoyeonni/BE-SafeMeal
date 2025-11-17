package com.example.safemeal.global.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class FoodSafetyApiClient {

    private final FoodApiProperties foodApiProperties;

    private static final String SERVICE_NAME = "COOKRCP01";

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonNode fetchRecipes(int start, int end) {
        try {
            URI uri = UriComponentsBuilder.fromHttpUrl(foodApiProperties.getBaseUrl())
                    .pathSegment(foodApiProperties.getServiceKey(), SERVICE_NAME, "json", String.valueOf(start), String.valueOf(end))
                    .build()
                    .toUri();

            String response = restTemplate.getForObject(uri, String.class);
            return objectMapper.readTree(response).path("COOKRCP01").path("row");

        } catch (Exception e) {
            throw new RuntimeException("OpenAPI 호출 실패: " + e.getMessage(), e);
        }
    }
}
