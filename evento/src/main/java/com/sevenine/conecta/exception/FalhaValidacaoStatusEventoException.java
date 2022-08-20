package com.connecta.evento.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class FalhaValidacaoStatusEventoException extends EventoRuntimeException {

    private String developMessage;
    private HttpStatus status;

    public FalhaValidacaoStatusEventoException(String developMessage, HttpStatus status) {
        this.status = status;
        this.developMessage = developMessage;
    }

}
