package com.sevenine.conecta.repositories.datas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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
