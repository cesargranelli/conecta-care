package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "atendimentos_campos_baixa")
@Entity
public class AtendimentoCampoBaixa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "atendimento_id")
    private Long atendimentoId;

    @Column(name = "campo_id")
    private Long campoId;

    private String texto;

}
