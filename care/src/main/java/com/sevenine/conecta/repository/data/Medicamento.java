package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "medicamentos")
@Entity
public class Medicamento {

    @Id
    private Long id;

    private String descricao;

    @ManyToOne
    private Procedimento procedimento;

}
