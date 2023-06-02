package com.sevenine.conecta.adapter.controller.advice;

import com.sevenine.conecta.exception.DadosNaoEncontradosException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class PlanoSaudeControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ DadosNaoEncontradosException.class })
    public ResponseEntity<Object> handleNodataFoundException(DadosNaoEncontradosException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", ex.getDevelopMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

}
