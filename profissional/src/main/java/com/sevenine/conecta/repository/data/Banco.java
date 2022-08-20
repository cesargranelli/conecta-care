package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "banco")
@Entity
public class Banco {

    @Id
    private Long id;

    private String codigo;
    private String descricao;

}
