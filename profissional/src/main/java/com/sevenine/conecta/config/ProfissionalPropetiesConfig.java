package com.sevenine.conecta.config;

import com.sevenine.conecta.config.properties.EndpointsAuthenticationProperties;
import com.sevenine.conecta.config.properties.EndpointsConnectaProperties;
import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        EndpointsConnectaProperties.class,
        ExceptionMessageProperties.class,
        EndpointsAuthenticationProperties.class
})
public class ProfissionalPropetiesConfig {
}
