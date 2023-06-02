package com.sevenine.conecta.repository.datas;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "instrucao")
@Entity(name = "Instrucao")
public class InstrucaoData {

    @Id
    private Long id;

    private String grau;

}
