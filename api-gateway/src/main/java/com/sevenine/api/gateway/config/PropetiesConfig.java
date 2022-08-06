package com.sevenine.api.gateway.config;

import com.sevenine.api.gateway.config.properties.EndpointsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        EndpointsProperties.class
})
public class PropetiesConfig {
}
