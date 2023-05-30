package com.sevenine.conecta.repositories.datas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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
