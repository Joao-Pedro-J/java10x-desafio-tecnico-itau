package com.jpdev.desafio_itau.controllers.dto;

public record EstatisticaResponse(
        Long count,
        Double sum,
        Double avg,
        Double min,
        Double max
) {
}
