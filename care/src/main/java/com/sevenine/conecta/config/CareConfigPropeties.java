package com.sevenine.conecta.config;

import com.sevenine.conecta.config.properties.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        ApplicationProperties.class,
        EndpointsPacienteProperties.class,
        EndpointsProfissionalProperties.class,
        ExceptionMessageProperties.class,
        EndpointsHomeCareProperties.class
})
public class CareConfigPropeties {
}
