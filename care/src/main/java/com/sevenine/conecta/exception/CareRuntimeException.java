package com.sevenine.conecta.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class CareRuntimeException extends RuntimeException {

    private String developMessage;
    private HttpStatus status;

    public CareRuntimeException(String developMessage, HttpStatus status) {
        super();
        this.status = status;
        this.developMessage = developMessage;
    }
}
