package com.sevenine.conecta.adapter.output.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "conselho")
@Entity(name = "Conselho")
public class ConselhoData {

    @Id
    private Long id;

    private String sigla;
    private String descricao;

}
