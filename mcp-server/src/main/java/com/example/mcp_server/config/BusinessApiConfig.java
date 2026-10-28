package com.example.mcp_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class BusinessApiConfig {

    @Bean
    RestClient businessRestClient() {
        return RestClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
    }
}