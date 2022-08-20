package com.sevenine.conecta.controller.handler;

import com.sevenine.conecta.controller.AtendimentoController;
import com.sevenine.conecta.exception.AtendimentoRuntimeException;
import com.sevenine.conecta.exception.CareRuntimeException;
import com.sevenine.conecta.exception.NaoLocalizadoException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice(basePackageClasses = AtendimentoController.class)
public class AtendimentoControllerHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            NaoLocalizadoException.class
    })
    public ResponseEntity<?> handleBusinessException(NaoLocalizadoException ex, WebRequest request) {
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler({CareRuntimeException.class})
    public ResponseEntity<?> handleBusinessException(CareRuntimeException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", ex.getDevelopMessage());

        return new ResponseEntity<>(body, ex.getStatus());
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
