package com.jpdev.desafio_itau.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "transacao")
@Validated
public record EstatisticaProperties(
        @NotNull(message = "O limite de segundos não pode ser nulo.")
        @Positive(message = "O limite de segundos deve ser um valor positivo.")
        Integer limiteSegundos
) {
}
