package com.jpdev.desafio_itau.models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record Transacao(
    BigDecimal valor,
    OffsetDateTime dataHora
) {}
