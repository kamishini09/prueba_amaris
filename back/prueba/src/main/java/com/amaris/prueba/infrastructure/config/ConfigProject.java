package com.amaris.prueba.infrastructure.config;

import com.amaris.prueba.infrastructure.api.ApiAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigProject {

    @Bean
    public ApiAdapter apiAdapter(RestTemplate restTemplate, @Value("${api.url}") String apiUrl) {
        return new ApiAdapter(restTemplate, apiUrl);
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
