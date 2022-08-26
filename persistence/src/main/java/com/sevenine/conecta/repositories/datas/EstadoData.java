package com.sevenine.conecta.repositories.datas;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
