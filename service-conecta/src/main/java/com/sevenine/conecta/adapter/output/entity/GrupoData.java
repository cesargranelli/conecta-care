package com.sevenine.conecta.adapter.output.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "grupo")
@Entity(name = "Grupo")
public class GrupoData {

    @Id
    private Long id;

    private String descricao;

}
