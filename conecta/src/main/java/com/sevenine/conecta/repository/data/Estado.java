package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "estado")
@Entity
public class Estado {

    @Id
    private Long id;

    private Integer codigo;
    private String uf;
    private String nome;
    private String regiao;

}
