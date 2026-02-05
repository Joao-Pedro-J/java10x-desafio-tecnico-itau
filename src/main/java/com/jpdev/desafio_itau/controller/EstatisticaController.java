package com.jpdev.desafio_itau.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpdev.desafio_itau.model.Estatistica;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    public ResponseEntity<Estatistica> obterEstatisticas() {
        // retorna as estatisticas das transacoes dos ultimos 60 segundos
        // return ResponseEntity.status(HttpStatus.OK).body(estatisticas);
        return null;
    }
    
}
