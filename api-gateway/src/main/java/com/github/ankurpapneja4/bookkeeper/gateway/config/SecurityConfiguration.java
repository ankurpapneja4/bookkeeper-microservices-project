package com.github.ankurpapneja4.bookkeeper.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration{

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http){

        http.authorizeExchange( exchanges -> exchanges.anyExchange().authenticated() )
                .httpBasic( withDefaults() )
                .csrf( csrfSpec -> csrfSpec.disable() );

        return http.build();
    }
}
