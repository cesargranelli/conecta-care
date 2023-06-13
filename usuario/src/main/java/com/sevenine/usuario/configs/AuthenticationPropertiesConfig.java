package com.sevenine.usuario.application.configuration;

import com.sevenine.usuario.application.configuration.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        SecurityProperties.class
})
public class AuthenticationPropertiesConfig {
}
