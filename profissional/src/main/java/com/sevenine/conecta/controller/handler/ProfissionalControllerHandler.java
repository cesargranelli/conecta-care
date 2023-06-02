package com.sevenine.conecta.adapter.controller.handler;

import com.sevenine.conecta.exception.GeneroNaoLocalizadoException;
import com.sevenine.conecta.exception.InformacaoNaoEncontradaException;
import com.sevenine.conecta.exception.ProfissionalRuntimeException;
import com.sevenine.conecta.exception.ServiceIndisponivelException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataAccessException;
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
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice(annotations = RestController.class)
public class ProfissionalControllerHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            InformacaoNaoEncontradaException.class,
            ServiceIndisponivelException.class,
            GeneroNaoLocalizadoException.class
    })
    public ResponseEntity<?> handleBusinessException(ProfissionalRuntimeException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", ex.getDevelopMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<?> handleServiceException(RuntimeException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({DataAccessException.class})
    public ResponseEntity<?> handleSqlException(DataAccessException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", Objects.requireNonNull(ex.getRootCause()).getLocalizedMessage());

        return new ResponseEntity<>(body, HttpStatus.PRECONDITION_FAILED);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("error", ex.getBindingResult().getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList()));
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
