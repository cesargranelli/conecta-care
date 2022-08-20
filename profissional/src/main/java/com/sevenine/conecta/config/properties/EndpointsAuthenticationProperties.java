package com.sevenine.conecta.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("endpoints.authentication")
public class EndpointsAuthenticationProperties {
    private String usuarioAtivacao;
}
