package com.academy.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Gestione Studenti API")
                        .version("1.0")
                        .description("API CRUD per la gestione dell'anagrafica studenti")
                        .contact(new Contact()
                                .name("Lorenzo Sansone")
                                .email("lorenzo.sansone@gmail.com")));
    }
}