package com.sevenine.conecta.config;

import com.sevenine.conecta.config.properties.EndpointsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        EndpointsProperties.class
})
public class PropetiesConfig {
}
