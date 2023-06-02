package com.sevenine.conecta.adapter.controller.advice;

import com.sevenine.conecta.exception.HomeCareNaoEncontradaException;
import com.sevenine.conecta.exception.InformacaoNaoLocalizadaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class HomeCareControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({HomeCareNaoEncontradaException.class})
    public ResponseEntity<Object> handleNodataFoundException(HomeCareNaoEncontradaException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", ex.getDevelopMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({InformacaoNaoLocalizadaException.class})
    public ResponseEntity<Object> informacaoNaoLocalizadaException() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
