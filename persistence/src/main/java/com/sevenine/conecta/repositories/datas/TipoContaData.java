package com.sevenine.conecta.repositories.datas;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
