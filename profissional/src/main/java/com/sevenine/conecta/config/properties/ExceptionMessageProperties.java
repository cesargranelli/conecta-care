package com.sevenine.conecta.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("exceptions.business.message")
public class ExceptionMessageProperties {
    private String serviceIndisponivel;
    private String generoNaoLocalizado;
    private String tipoEmpresaNaoLocalizado;
    private String estadoCivilNaoLocalizado;
    private String profissionalNaoEncontrado;
    private String enderecoNaoEncontrado;
    private String carreiraNaoEncontrado;
    private String experienciaNaoEncontrado;
    private String escolaridadeNaoEncontrado;
    private String contatoNaoEncontrado;
    private String complementoNaoEncontrado;
    private String contaNaoEncontrado;
    private String telefoneNaoEncontrado;
}
