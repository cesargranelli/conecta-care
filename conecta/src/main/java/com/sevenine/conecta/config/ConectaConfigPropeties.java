package com.sevenine.conecta.config;

import com.sevenine.conecta.config.properties.ConfirmacaoCadastroProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        ConfirmacaoCadastroProperties.class
})
public class ConectaConfigPropeties {
}
