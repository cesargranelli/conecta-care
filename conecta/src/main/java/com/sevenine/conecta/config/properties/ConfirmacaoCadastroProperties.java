package com.sevenine.conecta.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ConfigurationProperties("application.params.confirmacao.cadastro")
public class ConfirmacaoCadastroProperties {

    @NotNull(message = "Valor do application.params.emailFrom é obrigatório")
    private String emailFrom;

    @NotNull(message = "Valor do application.params.url é obrigatório")
    private String url;

    @NotNull(message = "Valor do application.params.assunto é obrigatório")
    private String assunto;

    @NotNull(message = "Valor do application.params.aviso é obrigatório")
    private String aviso;

}
