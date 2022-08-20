package com.sevenine.conecta.config;

import com.sevenine.conecta.config.properties.EndpointsAuthenticationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({EndpointsAuthenticationProperties.class})
public class PlanoSaudePropertiesConfig {
}
