package com.sevenine.conecta.application.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("security.configs")
public class SecurityProperties {
    private String signUpUrl;
    private String key;
    private Long expirationTime;
    private String endpointAtivacao;
}
