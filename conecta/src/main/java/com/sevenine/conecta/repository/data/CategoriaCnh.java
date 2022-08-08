package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "categoria_cnh")
@Entity
public class CategoriaCnh {

    @Id
    private Long id;

    private String sigla;

    private String descricao;

}
