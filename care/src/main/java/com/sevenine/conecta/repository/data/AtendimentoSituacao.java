package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "atendimentos_situacao")
@Entity
public class AtendimentoSituacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Atendimento atendimento;

    @OneToOne
    private StatusAtendimento status;

    private LocalDateTime dataHora;

}
