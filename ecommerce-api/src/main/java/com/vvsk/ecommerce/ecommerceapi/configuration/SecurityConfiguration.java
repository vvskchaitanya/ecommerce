package com.vvsk.ecommerce.ecommerceapi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vvsk.ecommerce.ecommerceapi.service.JwtTokenService;

import jakarta.annotation.PostConstruct;

@Configuration
public class SecurityConfiguration{

    @Autowired
    JwtTokenService tokenService;

    @Autowired
    ObjectMapper objectMapper;

    @PostConstruct()
    public void configure(){
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(c->c.disable());
        http.authorizeHttpRequests(req->{
            req.requestMatchers("/swagger-ui/**","/v3/**","/users/register","/authentication/login").permitAll()
            .anyRequest().authenticated();
        });
        return http.build();
    }

    
}
