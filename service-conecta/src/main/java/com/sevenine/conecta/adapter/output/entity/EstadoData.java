package com.sevenine.conecta.adapter.output.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "estado")
@Entity(name = "Estado")
public class EstadoData {

    @Id
    private Long id;

    private Integer codigo;
    private String uf;
    private String nome;
    private String regiao;

}
