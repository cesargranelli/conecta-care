package com.sevenine.conecta.adapter.output.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "tipo_conta")
@Entity(name = "TipoConta")
public class TipoContaData {

    @Id
    private Long id;

    private String codigo;
    private String descricao;

}
