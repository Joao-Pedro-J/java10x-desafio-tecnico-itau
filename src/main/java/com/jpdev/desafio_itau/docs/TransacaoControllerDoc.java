package com.jpdev.desafio_itau.docs;

import org.springframework.http.ResponseEntity;

import com.jpdev.desafio_itau.controllers.dto.TransacaoRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
    name = "Transacao",
    description = "Endpoints para validação e gerenciamento de transações"
)
public interface TransacaoControllerDoc {

    @Operation(
        summary = "Salvar transação",
        description = "Salva uma nova transação" 
    )
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "201", description = "Transação criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida (dados ausentes ou formato incorreto)"),
            @ApiResponse(responseCode = "422", description = "Transação inválida (dataHora no futuro)")
        }
    )
    ResponseEntity<?> salvarTransacao(TransacaoRequest transacaoRequest);

    @Operation(
        summary = "Deletar todas as transações",
        description = "Remove todas as transações armazenadas"
    )
    @ApiResponse(
        responseCode = "200", 
        description = "Todas as transações foram deletadas com sucesso"
    )
    public ResponseEntity<?> deletarTransacoes();
}
