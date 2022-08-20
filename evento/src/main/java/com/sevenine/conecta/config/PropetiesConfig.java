package com.connecta.evento.config;

import com.connecta.evento.config.properties.ApplicationProperties;
import com.connecta.evento.config.properties.EndpointsProperties;
import com.connecta.evento.config.properties.ExceptionMessageProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        ApplicationProperties.class,
        EndpointsProperties.class,
        ExceptionMessageProperties.class
})
public class PropetiesConfig {
}
