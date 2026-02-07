package com.jpdev.desafio_itau.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "transacao")
@Validated
public record EstatisticaProperties(
        @Positive(message = "Deve ser um valor positivo.")
        Integer limiteSegundos
) {
}
