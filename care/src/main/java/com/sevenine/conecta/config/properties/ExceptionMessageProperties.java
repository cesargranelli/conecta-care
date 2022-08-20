package com.sevenine.conecta.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("exceptions.business.message")
public class ExceptionMessageProperties {
    private String atendimentoNaoLocalizado;
    private String servicePacienteIndisponivel;
    private String serviceHomeCareIndisponivel;
    private String serviceProfissionalIndisponivel;
}
