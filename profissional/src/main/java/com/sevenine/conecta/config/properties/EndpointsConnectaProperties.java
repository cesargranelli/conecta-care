package com.sevenine.conecta.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("endpoints.connecta")
public class EndpointsConnectaProperties {
    private String dominioGenero;
    private String dominioTipoEmpresa;
    private String dominioEstadoCivil;
    private String consultaDocumento;
}
