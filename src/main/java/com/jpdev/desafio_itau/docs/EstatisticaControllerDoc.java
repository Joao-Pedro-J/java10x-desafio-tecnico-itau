package com.jpdev.desafio_itau.docs;

import org.springframework.http.ResponseEntity;

import com.jpdev.desafio_itau.dto.EstatisticaResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
    name = "Estatistica",
    description = "Endpoint para obtenção de estatísticas das transações"
)
public interface EstatisticaControllerDoc {

    @Operation(
        summary = "Obter estatísticas das transações",
        description = "Retorna as estatísticas das transações válidas nos últimos ${transacao.limite-segundos} segundos"
    )
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Estatísticas obtidas com sucesso")
        }
    )
    ResponseEntity<EstatisticaResponse> obterEstatisticas();

}
