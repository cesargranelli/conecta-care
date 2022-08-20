package com.connecta.evento.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class EventoRuntimeException extends RuntimeException {

    private String developMessage;
    private HttpStatus status;

    public EventoRuntimeException(String developMessage, HttpStatus status) {
        super();
        this.status = status;
        this.developMessage = developMessage;
    }
}
