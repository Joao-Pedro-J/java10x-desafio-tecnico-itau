package com.jpdev.desafio_itau.controllers;

import com.jpdev.desafio_itau.dto.EstatisticaResponse;
import com.jpdev.desafio_itau.services.EstatisticaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {
    private final EstatisticaService service;

    public EstatisticaController(EstatisticaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<EstatisticaResponse> obterEstatisticas() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.obterEstatisticas());
    }
}
