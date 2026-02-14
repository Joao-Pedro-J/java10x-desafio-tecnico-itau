package com.jpdev.desafio_itau.services;

import com.jpdev.desafio_itau.config.properties.EstatisticaProperties;
import com.jpdev.desafio_itau.controllers.dto.EstatisticaResponse;
import com.jpdev.desafio_itau.models.Transacao;
import com.jpdev.desafio_itau.repositories.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class EstatisticaService {
    // Logger para exibir as mensagens de erro, informação e etc...
    private static final Logger log = LoggerFactory.getLogger(EstatisticaService.class);

    private final TransacaoRepository repository;
    private final EstatisticaProperties properties;

    public EstatisticaService(TransacaoRepository repository,
                              EstatisticaProperties properties) {
        this.repository = repository;
        this.properties = properties;
    }

    public EstatisticaResponse obterEstatisticas() {
        // Marca o tempo decorrido para finalizar essa operação.
        StopWatch watch = new StopWatch();

        log.info("Iniciando calculo de estatisticas com o limite de {} segundos.", properties.limiteSegundos());
        watch.start();

        List<Transacao> transacoes = repository.obterTransacoes();

        var summary = transacoes.stream()
                .filter(t -> t.dataHora()
                        .isAfter(OffsetDateTime
                            .now()
                            .minusSeconds(properties.limiteSegundos())))
                .mapToDouble(t -> t.valor().doubleValue())
                .summaryStatistics();

        if (summary.getCount() == 0) {
            log.info("Nenhuma transação encontrada nos últimos {} segundos. Retornando estatísticas zeradas.",
                    properties.limiteSegundos());
            return new EstatisticaResponse(0L, 0.0, 0.0, 0.0, 0.0);
        }
        watch.stop();
        log.info("Tempo decorrido para calcular as estatisticas das transações: {} ms", watch.getTotalTimeMillis());

        return new EstatisticaResponse(
                summary.getCount(),
                summary.getSum(),
                summary.getAverage(),
                summary.getMin(),
                summary.getMax()
        );
    }
}
