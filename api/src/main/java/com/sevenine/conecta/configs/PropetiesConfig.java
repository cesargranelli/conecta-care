package com.sevenine.conecta.configs;

import com.sevenine.conecta.configs.properties.EndpointsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        EndpointsProperties.class
})
public class PropetiesConfig {
}
