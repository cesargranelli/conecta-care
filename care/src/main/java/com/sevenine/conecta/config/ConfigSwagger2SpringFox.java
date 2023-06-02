package com.sevenine.conecta.config;

import com.sevenine.conecta.adapter.controller.AtendimentoController;
import com.sevenine.conecta.adapter.controller.TratamentoController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackageClasses = {AtendimentoController.class, TratamentoController.class})
@EnableSwagger2
public class ConfigSwagger2SpringFox {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

}
