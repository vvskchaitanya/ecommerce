package com.vvsk.ecommerce.ecommerceapi.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import jakarta.annotation.PostConstruct;

@Configuration
public class SecurityConfiguration{

    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    ObjectMapper objectMapper;

    @Value("app.public.endpoints")
    String[] allowList;

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
        http.addFilterAfter(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
        http.authorizeHttpRequests(req->{
            req.requestMatchers("/","/swagger-ui/**","/v3/**","/users/register","/authentication/login").permitAll()
            .requestMatchers(allowList).permitAll()
            .anyRequest().authenticated();
        });
        return http.build();
    }

    
}
