package com.sevenine.conecta.configs;

import com.sevenine.conecta.configs.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        SecurityProperties.class
})
public class PropertiesConfiguration {
}
