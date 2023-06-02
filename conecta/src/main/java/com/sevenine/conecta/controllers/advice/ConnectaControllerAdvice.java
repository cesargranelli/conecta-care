package com.sevenine.conecta.adapter.controller.advice;

import com.sevenine.conecta.exception.DocumentoDuplicadoException;
import com.sevenine.conecta.exception.DocumentoNaoEncontradoException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice(annotations = RestController.class)
public class ConnectaControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ DocumentoNaoEncontradoException.class })
    public ResponseEntity<?> handleNodataFoundException(DocumentoNaoEncontradoException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", ex.getDevelopMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ DocumentoDuplicadoException.class })
    public ResponseEntity<?> handleDuplicaException(DocumentoDuplicadoException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", ex.getDevelopMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("error", ex.getBindingResult().getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList()));
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
