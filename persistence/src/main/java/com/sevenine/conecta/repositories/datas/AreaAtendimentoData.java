package com.sevenine.conecta.repositories.datas;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "area_atendimento")
@Entity(name = "AreaAtendimento")
public class AreaAtendimentoData {

    @Id
    private Long id;

    private String nome;

}
