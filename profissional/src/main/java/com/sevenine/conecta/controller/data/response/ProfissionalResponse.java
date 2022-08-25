package com.sevenine.conecta.controllers.data.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfissionalResponse {
    private Long id;
    private String cpf;
    private String nome;
    private String sobrenome;
    private String dataNascimento;
    private String rg;
    private String rgEmissor;
    private String rgDataEmissao;
    private String cnpj;
    private Long ctps;
    private String ctpsSerie;
    private Long pis;
    private String fotoCtps;
    private String fotoProfissional;
    private String fotoRgFrente;
    private String fotoRgVerso;
    private String fotoAssinatura;
    private Boolean disponivelParaAtendimento;
    private GeneroResponse genero;
    private TipoEmpresaResponse tipoEmpresa;
    private EstadoCivilResponse estadoCivil;
    @JsonIgnore
    private List<Object> eventos;
}
