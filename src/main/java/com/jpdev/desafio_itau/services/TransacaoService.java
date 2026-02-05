package com.jpdev.desafio_itau.services;

import com.jpdev.desafio_itau.dto.TransacaoRequest;
import com.jpdev.desafio_itau.exceptions.DateTimeFutureException;
import com.jpdev.desafio_itau.models.Transacao;
import com.jpdev.desafio_itau.repositories.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class TransacaoService {
    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public void salvarTransacao(TransacaoRequest transacaoRequest) {
        if (transacaoRequest.dataHora().isAfter(OffsetDateTime.now())) {
            throw new DateTimeFutureException("DataHora não pode ser no futuro.");
        }

        repository.salvarTransacao(new Transacao(transacaoRequest.valor(), transacaoRequest.dataHora()));
    }

    public void deletarTransacoes() {
        repository.deletarTransacoes();
    }
}
