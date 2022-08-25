package com.sevenine.conecta.config;

import com.sevenine.conecta.config.properties.ApplicationProperties;
import com.sevenine.conecta.config.properties.EndpointsProperties;
import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        ApplicationProperties.class,
        EndpointsProperties.class,
        ExceptionMessageProperties.class
})
public class EventoPropetiesConfig {
}
