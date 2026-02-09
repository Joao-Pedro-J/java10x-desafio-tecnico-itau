package com.jpdev.desafio_itau.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
            .info(
                new Info()
                .title("Desafio Itau + Java10X")
                .description("API desefio tecnico do Itau + Java10X")
                .version("1.0.0")
            );
    }

}
