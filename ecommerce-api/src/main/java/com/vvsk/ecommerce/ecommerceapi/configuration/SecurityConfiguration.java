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

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
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
    OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("Keystone EduTech - E-commerce Web API")
                        .description("Complete E-Commerce API built using Java and Spring Boot Framework")
                        .license(new License()
                                .name("@V.V.S.K Chaitanya")
                                .url("https://www.gnu.org/licenses/agpl-3.0.html")));

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(c->c.disable());
        return http.build();
    }

    
}
