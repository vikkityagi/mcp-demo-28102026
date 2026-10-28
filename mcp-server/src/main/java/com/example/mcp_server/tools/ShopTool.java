package com.example.mcp_server.tools;

import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ShopTool {

    private final RestClient restClient;

    public ShopTool(RestClient businessRestClient) {
        this.restClient = businessRestClient;
    }

    @McpTool(description = "Add two numbers")
    public String add(
            @McpToolParam(description = "First number") int a,
            @McpToolParam(description = "Second number") int b) {

        return restClient.get()
                .uri("/calculator/add?a={a}&b={b}", a, b)
                .retrieve()
                .body(String.class);
    }

    @McpTool(description = "Get weather for a city")
    public String getWeather(
            @McpToolParam(description = "City name") String city) {

        return restClient.get()
                .uri("/weather?city={city}", city)
                .retrieve()
                .body(String.class);
    }

    @McpTool(description = "Get order status by order ID")
    public String getOrderStatus(
            @McpToolParam(description = "Order ID") long id) {

        return restClient.get()
                .uri("/orders/{id}", id)
                .retrieve()
                .body(String.class);
    }
}