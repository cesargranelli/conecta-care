package com.sevenine.conecta.repository.datas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "area_atendimento")
@Entity(name = "AreaAtendimento")
public class AreaAtendimentoData {

    @Id
    private Long id;

    private String nome;

}
