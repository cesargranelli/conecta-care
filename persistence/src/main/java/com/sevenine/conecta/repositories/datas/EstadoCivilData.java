package com.sevenine.conecta.repositories.datas;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "estado_civil")
@Entity(name = "EstadoCivil")
public class EstadoCivilData {

    @Id
    private Long id;

    private String tipo;
    private String descricao;

}
