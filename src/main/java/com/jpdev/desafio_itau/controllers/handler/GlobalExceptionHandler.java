package com.jpdev.desafio_itau.controllers.handler;

import com.jpdev.desafio_itau.exceptions.DateTimeFutureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors().stream()
                .map(error -> new validationError(error.getField(), error.getDefaultMessage()))
                .toList();

        log.warn("Problema na validação dos campos {} erro: {}",
                errors.stream().map(error -> error.field).toList(),
                errors.stream().map(error -> error.message).toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(DateTimeFutureException.class)
    public ResponseEntity<?> dateTimeValidation(DateTimeFutureException ex) {
        log.warn("Problema na validação do campo dataHora. erro: {}", ex.getMessage());

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT)
                .body(new validationError("dataHora", ex.getMessage()));
    }

    private record validationError(String field, String message) {}
}
