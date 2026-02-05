package com.jpdev.desafio_itau.services;

import com.jpdev.desafio_itau.dto.EstatisticaResponse;
import com.jpdev.desafio_itau.models.Transacao;
import com.jpdev.desafio_itau.repositories.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.List;

@Service
public class EstatisticaService {
    private final TransacaoRepository repository;

    public EstatisticaService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public EstatisticaResponse obterEstatisticas() {
        List<Transacao> transacoes = repository.obterTransacoes();

        List<Transacao> transacoes60Seconds = transacoes.stream()
                .filter(tr -> tr.dataHora().isAfter(OffsetDateTime.now().minusSeconds(60)))
                .toList();

        if (!transacoes60Seconds.isEmpty()) {
            Long count = (long) transacoes60Seconds.size();

            Double sum = transacoes60Seconds.stream()
                    .mapToDouble(transacao -> transacao.valor().doubleValue())
                    .sum();

            Double avg = transacoes60Seconds.stream()
                    .map(Transacao::valor)
                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                    .divide(BigDecimal.valueOf(transacoes60Seconds.size()), RoundingMode.HALF_UP)
                    .doubleValue();

            Double min = transacoes60Seconds.stream()
                    .map(Transacao::valor)
                    .min(BigDecimal::compareTo)
                    .map(BigDecimal::doubleValue)
                    .orElse(0.0);

            Double max = transacoes60Seconds.stream()
                    .map(Transacao::valor)
                    .max(BigDecimal::compareTo)
                    .map(BigDecimal::doubleValue)
                    .orElse(0.0);

            return new EstatisticaResponse(count, sum, avg, min, max);
        }

        return null;
    }
}
