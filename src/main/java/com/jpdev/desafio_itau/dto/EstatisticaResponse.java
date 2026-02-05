package com.jpdev.desafio_itau.dto;

public record EstatisticaResponse(
        Long count,
        Double sum,
        Double avg,
        Double min,
        Double max
) {
}
