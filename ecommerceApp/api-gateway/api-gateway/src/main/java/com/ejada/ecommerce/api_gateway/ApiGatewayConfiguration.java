package com.ejada.ecommerce.api_gateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.UriSpec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p->p.path("/get").filters(f->f
                .addRequestHeader("MyHeader", "MyURI"))
                .uri("http://httpbin.org:80"))
                .route(p->p.path("/wallet-service/**").uri("lb://WALLET-SERVICE"))
                .route(p->p.path("/shop-service/**").uri("lb://SHOP-SERVICE"))
                .route(p->p.path("/inventory-service/**").uri("lb://INVENTORY-SERVICE"))
                .build();
    }
}
