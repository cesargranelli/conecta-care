package com.sevenine.conecta.repositories.datas;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "banco")
@Entity(name = "Banco")
public class BancoData {

    @Id
    private Long id;

    private String codigo;
    private String descricao;

}
