package com.example.safemeal.global.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "openapi.food")
public class FoodApiProperties {

    private String baseUrl;
    private String serviceKey;

}