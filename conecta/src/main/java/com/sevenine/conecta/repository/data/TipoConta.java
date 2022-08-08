package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "tipo_conta")
@Entity
public class TipoConta {

    @Id
    private Long id;

    private String codigo;
    private String descricao;

}
