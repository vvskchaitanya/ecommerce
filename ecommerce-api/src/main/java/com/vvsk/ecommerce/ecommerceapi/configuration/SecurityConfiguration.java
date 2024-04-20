package com.vvsk.ecommerce.ecommerceapi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.JwtException;

import com.vvsk.ecommerce.ecommerceapi.service.JwtTokenService;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    JwtTokenService tokenService;

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("Ecommerce API")
                        .description("Complete E-Commerce API built using Java and Spring Boot Framework")
                        .license(new License()
                                .name("@Keystone Edu Tech")
                                .url("https://www.gnu.org/licenses/agpl-3.0.html")));

    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return new JwtDecoder() {
            @Override
            public Jwt decode(String token) throws JwtException {

                return new Jwt(tokenService.extractUsername(token), null, null, null, null);
            }
        };
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                .requestMatchers("/authentication/login","/swagger-ui/index.html").permitAll()
                .requestMatchers("/public/**").permitAll() // Define public endpoints
                .anyRequest().authenticated() // All other requests require authentication
            )
            .oauth2ResourceServer(oauth2ResourceServer ->
                oauth2ResourceServer
                    .jwt(jwt -> jwt.decoder(jwtDecoder()))
            );
    }

}
