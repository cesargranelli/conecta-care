package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "escolaridade")
@Entity
public class Escolaridade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Instrucao instrucao;

    private String instituicaoEnsino;
    private String anoConclusao;

    @OneToOne
    private Profissional profissional;

}
