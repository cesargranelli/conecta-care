package com.sevenine.conecta.repository.datas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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
