package com.jpdev.desafio_itau.model;

import java.time.OffsetDateTime;

public record Transacao(
    Double valor,
    OffsetDateTime dataHora
) {
    
}
