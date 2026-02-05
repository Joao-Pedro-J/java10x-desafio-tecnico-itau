package com.jpdev.desafio_itau.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpdev.desafio_itau.model.Transacao;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @PostMapping() 
    public ResponseEntity<Void> validarTransacao(@RequestBody Transacao transacao) {
        
        // se for valida
        // return ResponseEntity.status(HttpStatus.CREATED).build();

        // se algum campo for nulo
        // return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        // se dataHora for maior que o momento atual.
        // return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).build();

        return null;
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletarTransacoesI() {

        // deleta todas as transacoes
        // return ResponseEntity.status(HttpStatus.OK).build();
    }
    
}
