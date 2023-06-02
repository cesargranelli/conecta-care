package com.sevenine.conecta.repository.datas;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "pais")
@Entity(name = "Pais")
public class PaisData {

    @Id
    private Long id;

    private String codigo;
    private String nome;

}
