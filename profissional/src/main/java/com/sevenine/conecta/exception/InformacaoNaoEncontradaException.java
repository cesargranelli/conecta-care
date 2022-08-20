package com.sevenine.conecta.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class InformacaoNaoEncontradaException extends ProfissionalRuntimeException {

    private String developMessage;
    private HttpStatus status;

    public InformacaoNaoEncontradaException(String developMessage, HttpStatus status) {
        this.status = status;
        this.developMessage = developMessage;
    }

}
