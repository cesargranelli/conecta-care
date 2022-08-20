package com.connecta.evento.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Getter
@Setter
@ConfigurationProperties("endpoints")
public class EndpointsProperties {
    private Map<String, String> evento;
    private Map<String, String> sms;
}
