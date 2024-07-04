package com.vvsk.ecommerce.ecommerceapi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.authorization.method.PreAuthorizeAuthorizationManager;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.method.MethodSecurityBeanDefinitionParser.MethodSecurityExpressionHandlerBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import jakarta.annotation.PostConstruct;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration{

    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    ObjectMapper objectMapper;

    @Value("#{'${app.public.endpoints}'.split(',')}")
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
            req.requestMatchers(allowList).permitAll()
            .anyRequest().authenticated();
        });
        return http.build();
    }

    
}
