package com.sevenine.conecta.repository.datas;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "genero")
@Entity(name = "Genero")
public class GeneroData {

    @Id
    private Long id;

    private String tipo;
    private String descricao;

}
