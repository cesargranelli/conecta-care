package com.sevenine.conecta.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class EventoNaoEncontradoException extends EventoRuntimeException {

    private String developMessage;
    private HttpStatus status;

    public EventoNaoEncontradoException(String developMessage, HttpStatus status) {
        this.status = status;
        this.developMessage = developMessage;
    }

}
