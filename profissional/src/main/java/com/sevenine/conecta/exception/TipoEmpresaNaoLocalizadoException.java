package com.sevenine.conecta.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class TipoEmpresaNaoLocalizadoException extends ProfissionalRuntimeException {

    private String developMessage;
    private HttpStatus status;

    public TipoEmpresaNaoLocalizadoException(String developMessage, HttpStatus status) {
        this.status = status;
        this.developMessage = developMessage;
    }

}
