package com.sevenine.conecta.repository.datas;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "categoria_cnh")
@Entity(name = "CategoriaCnh")
public class CategoriaCnhData {

    @Id
    private Long id;

    private String sigla;

    private String descricao;

}
