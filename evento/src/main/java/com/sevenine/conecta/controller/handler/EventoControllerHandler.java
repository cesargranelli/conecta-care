package com.connecta.evento.controller.handler;

import com.connecta.evento.exception.EventoNaoEncontradoException;
import com.connecta.evento.exception.EventoRuntimeException;
import com.connecta.evento.exception.FalhaValidacaoStatusEventoException;
import com.connecta.evento.exception.ServiceIndisponivelException;
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
public class EventoControllerHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            ServiceIndisponivelException.class,
            FalhaValidacaoStatusEventoException.class
    })
    public ResponseEntity<?> handleBusinessException(EventoRuntimeException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", ex.getDevelopMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            EventoNaoEncontradoException.class
    })
    public ResponseEntity<?> handleNoContentException(EventoRuntimeException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();

        return new ResponseEntity<>(body, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<?> handleServiceException(RuntimeException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", ex.getLocalizedMessage());

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
