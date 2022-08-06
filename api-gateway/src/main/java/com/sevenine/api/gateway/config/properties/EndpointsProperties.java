package com.sevenine.api.gateway.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("url.services")
public class EndpointsProperties {
    private String authentication;
    private String homeCare;
    private String planoSaude;
    private String paciente;
    private String connecta;
    private String profissional;
    private String evento;
    private String care;
}
