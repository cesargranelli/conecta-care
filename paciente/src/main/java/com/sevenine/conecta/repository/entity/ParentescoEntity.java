package com.sevenine.conecta.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "parentesco")
@Entity
public class ParentescoEntity {

    @Id
    private Long id;

    private String descricao;

}
