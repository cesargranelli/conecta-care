package com.sevenine.conecta.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class NaoExisteTratamentoEmAbertoException extends CareRuntimeException {

    private String developMessage;
    private HttpStatus status;

    public NaoExisteTratamentoEmAbertoException(String developMessage, HttpStatus status) {
        super();
        this.status = status;
        this.developMessage = developMessage;
    }
}
