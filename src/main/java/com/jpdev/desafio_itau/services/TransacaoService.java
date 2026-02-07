package com.jpdev.desafio_itau.services;

import com.jpdev.desafio_itau.dto.TransacaoRequest;
import com.jpdev.desafio_itau.exceptions.DateTimeFutureException;
import com.jpdev.desafio_itau.models.Transacao;
import com.jpdev.desafio_itau.repositories.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class TransacaoService {
    private static final Logger log = LoggerFactory.getLogger(TransacaoService.class);
    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public void salvarTransacao(TransacaoRequest transacaoRequest) {
        log.info("Salvando transação.");
        if (transacaoRequest.dataHora().isAfter(OffsetDateTime.now())) {
            throw new DateTimeFutureException("DataHora não pode ser no futuro.");
        }

        repository.salvarTransacao(new Transacao(transacaoRequest.valor(), transacaoRequest.dataHora()));
        log.info("Transação salva com sucesso!");
    }

    public void deletarTransacoes() {
        log.info("Deletando todas as transações.");

        repository.deletarTransacoes();

        log.info("Transaçõe deletadas com sucesso!");
    }
}
