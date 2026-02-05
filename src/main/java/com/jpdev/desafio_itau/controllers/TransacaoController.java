package com.jpdev.desafio_itau.controllers;

import com.jpdev.desafio_itau.dto.TransacaoRequest;
import com.jpdev.desafio_itau.services.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpdev.desafio_itau.models.Transacao;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> validarTransacao(@RequestBody @Valid TransacaoRequest transacaoRequest) {
        service.salvarTransacao(transacaoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping()
    public ResponseEntity<?> deletarTransacoes() {
        service.deletarTransacoes();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
}
