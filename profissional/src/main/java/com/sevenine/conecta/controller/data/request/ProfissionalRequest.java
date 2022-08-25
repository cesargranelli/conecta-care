package com.sevenine.conecta.controllers.data.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProfissionalRequest {

    private Long id;
    private String cpf;
    private String nome;
    private String sobrenome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String rg;
    private String rgEmissor;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate rgDataEmissao;

    private String cnpj;
    private String ctps;
    private String ctpsSerie;
    private String pis;
    private Long genero;
    private Long tipoEmpresa;
    private Long estadoCivil;
    private String fotoProfissional;
    private String fotoRgFrente;
    private String fotoRgVerso;
    private String fotoAssinatura;
    private String fotoCtps;
    private Boolean disponivelParaAtendimento;

}
