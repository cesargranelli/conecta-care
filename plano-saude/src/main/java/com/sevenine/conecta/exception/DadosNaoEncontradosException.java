package com.sevenine.conecta.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class DadosNaoEncontradosException extends RuntimeException {

    private String developMessage;
    private HttpStatus status;

    public DadosNaoEncontradosException(String developMessage, HttpStatus status) {
        super();
        this.status = status;
        this.developMessage = developMessage;
    }

}
