package com.sevenine.conecta.repositories.datas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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
