package com.connecta.evento.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("exceptions.busines.message")
public class ExceptionMessageProperties {
    private String serviceIndisponivel;
    private String eventoNaoEncontrado;
    private String falhaEncerrarEvento;
    private String falhaValidacaoStatus;
    private String falhaEnviarSms;
}
