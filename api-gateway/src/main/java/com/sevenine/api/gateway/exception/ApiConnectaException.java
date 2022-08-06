package com.sevenine.api.gateway.exception;

import com.sevenine.api.gateway.exception.enumerator.ErrorMappingEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiConnectaException extends RuntimeException {

    private String mensagem;
    private String developMessage;
    private HttpStatus status;

    public ApiConnectaException(String mensagem, HttpStatus status) {
        super();
        this.mensagem = mensagem;
        this.status = status;
    }

    public ApiConnectaException(ErrorMappingEnum errorEnum, String developMessage, HttpStatus status) {
        super();
        this.mensagem = errorEnum.getMensagem();
        this.status = status;
        this.developMessage = developMessage;
    }

}
