package com.jpdev.desafio_itau.repositories;

import com.jpdev.desafio_itau.models.Transacao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransacaoRepository {
    private final List<Transacao> transacaos;

    public TransacaoRepository() {
        this.transacaos = new ArrayList<>();
    }

    public void salvarTransacao(Transacao transacao) {
        transacaos.add(transacao);
    }

    public List<Transacao> obterTransacoes() {
        return transacaos;
    }

    public void deletarTransacoes() {
        transacaos.clear();
    }

}
