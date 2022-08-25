package com.sevenine.conecta.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class FalhaEncerrarEventoException extends EventoRuntimeException {

    private String developMessage;
    private HttpStatus status;

    public FalhaEncerrarEventoException(String developMessage, HttpStatus status) {
        this.status = status;
        this.developMessage = developMessage;
    }

}
