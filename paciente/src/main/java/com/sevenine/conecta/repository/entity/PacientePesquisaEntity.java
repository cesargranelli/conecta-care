package com.sevenine.conecta.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "paciente")
@Entity(name = "PacientePesquisa")
public class PacientePesquisaEntity {

    @Id
    private Long id;

    private String cpf;
    private String nome;
    private String sobrenome;
}
