package com.jpdev.desafio_itau.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.*;

public record Transacao(
    @NotNull(message = "Valor não pode ser nulo.")
    @PositiveOrZero(message = "Valor não pode ser negativo.")
    BigDecimal valor,

    @NotNull(message = "DataHora não pode ser nulo.")
    OffsetDateTime dataHora
) {}
