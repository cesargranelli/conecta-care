package com.sevenine.conecta.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "area_atendimento")
@Entity
public class Especialidade {

    @Id
    private long id;

    private String nome;

}
