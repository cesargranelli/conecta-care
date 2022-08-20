package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "pais")
@Entity
public class Pais {

    @Id
    private Long id;

    private String codigo;
    private String nome;

}
