package com.sevenine.conecta.repositories.datas;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "grupo")
@Entity(name = "Grupo")
public class GrupoData {

    @Id
    private Long id;

    private String descricao;

}
