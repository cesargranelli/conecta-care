package com.sevenine.conecta.infra.exception;

import com.sevenine.conecta.infra.enumerator.ErrorMappingEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class PacienteException extends RuntimeException {

    private String mensagem;
    private String developMessage;
    private HttpStatus status;

    public PacienteException(String mensagem, HttpStatus status) {
        super();
        this.mensagem = mensagem;
        this.status = status;
    }

    public PacienteException(ErrorMappingEnum errorMappingEnum, HttpStatus status) {
        super();
        this.mensagem = errorMappingEnum.getMensagem();
        this.status = status;
        this.developMessage = errorMappingEnum.getMensagem();
    }

}