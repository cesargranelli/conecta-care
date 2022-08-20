package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Table(name = "profissionais")
@Entity
public class Profissional {

    @Id
    private Long id;

    private String cpf;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String rg;
    private String rgEmissor;
    private LocalDate rgDataEmissao;
    private String cnpj;
    private Long ctps;
    private String ctpsSerie;
    private Long pis;
    private String fotoProfissional;
    private String fotoRgFrente;
    private String fotoRgVerso;
    private String fotoAssinatura;
    private String fotoCtps;
    private Boolean disponivelParaAtendimento;

    @ManyToOne
    private Genero genero;

    @ManyToOne
    private TipoEmpresa tipoEmpresa;

    @ManyToOne
    private EstadoCivil estadoCivil;

}
