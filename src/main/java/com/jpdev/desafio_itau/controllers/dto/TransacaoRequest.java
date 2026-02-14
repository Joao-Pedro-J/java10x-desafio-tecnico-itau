package com.jpdev.desafio_itau.controllers.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransacaoRequest(
        @NotNull(message = "Valor não pode ser nulo.")
        @PositiveOrZero(message = "Valor não pode ser negativo.")
        BigDecimal valor,

        @NotNull(message = "DataHora não pode ser nulo.")
        OffsetDateTime dataHora
) {
}
