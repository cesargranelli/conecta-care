package com.connecta.evento.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("application.params.sms")
public class ApplicationProperties {
    private String clienteSms;
}
