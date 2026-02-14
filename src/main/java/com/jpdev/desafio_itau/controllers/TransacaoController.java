package com.jpdev.desafio_itau.controllers;

import com.jpdev.desafio_itau.docs.TransacaoControllerDoc;
import com.jpdev.desafio_itau.controllers.dto.TransacaoRequest;
import com.jpdev.desafio_itau.services.TransacaoService;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController implements TransacaoControllerDoc {

    private static final Logger log = LoggerFactory.getLogger(TransacaoController.class);
    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> salvarTransacao(@RequestBody @Valid TransacaoRequest transacaoRequest) {
        log.info("Requisição POST recebida para o endpoint /transacao");

        service.salvarTransacao(transacaoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping()
    public ResponseEntity<?> deletarTransacoes() {
        log.info("Requisição DELETE recebida para o endpoint /transacao");

        service.deletarTransacoes();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
}
