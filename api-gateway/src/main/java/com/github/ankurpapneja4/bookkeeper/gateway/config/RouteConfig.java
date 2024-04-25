package com.github.ankurpapneja4.bookkeeper.gateway.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator routeFunction(RouteLocatorBuilder routeBuilder){
        return routeBuilder.routes()
                    .route( "accounts-service",
                            r -> r.path("/bookkeeper/accounts-service/**")
                                    .filters( f -> f.rewritePath("/bookkeeper/accounts-service/(?<segment>.*)", "/${segment}") )
                                      .uri("lb://accounts-service"))
                .build();
    }
}
