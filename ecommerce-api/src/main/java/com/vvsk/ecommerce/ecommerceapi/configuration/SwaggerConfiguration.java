package com.vvsk.ecommerce.ecommerceapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;

@Configuration
@SecurityScheme(
        name = "Authorization",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer"
)
public class SwaggerConfiguration{

    @Bean
    OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("Keystone EduTech - E-commerce Web API")
                        .description("Complete E-Commerce API built using Java and Spring Boot Framework")
                        .license(new License()
                                .name("@V.V.S.K Chaitanya")
                                .url("https://www.gnu.org/licenses/agpl-3.0.html"))
                                ).addSecurityItem(new SecurityRequirement().addList("Authorization"));

    }
    
}
