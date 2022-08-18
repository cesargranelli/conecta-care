package com.sevenine.conecta.http.care.config;

import com.sevenine.conecta.http.care.config.properties.EndpointsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        EndpointsProperties.class
})
public class PropetiesConfig {
}
