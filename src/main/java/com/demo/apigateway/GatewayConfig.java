package com.demo.apigateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder,
                               @Value("${product.service.url}") String productUrl,
                               @Value("${order.service.url}") String orderUrl) {
        return builder.routes()
                .route("product-service", r -> r.path("/products/**").uri(productUrl))
                .route("order-service", r -> r.path("/orders/**").uri(orderUrl))
                .build();
    }
}