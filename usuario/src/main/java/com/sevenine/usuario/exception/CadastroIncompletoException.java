package com.sevenine.usuario.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

@Getter
@Setter
public class CadastroIncompletoException extends AuthenticationException {

    private String developMessage;
    private HttpStatus status;

    public CadastroIncompletoException(String developMessage, HttpStatus status) {
        super(developMessage);
        this.developMessage = developMessage;
        this.status = status;
    }

}
