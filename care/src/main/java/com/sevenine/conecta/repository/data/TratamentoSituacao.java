package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "tratamentos_situacao")
@Entity
public class TratamentoSituacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Tratamento tratamento;

    @OneToOne
    private StatusTratamento status;

    @CreationTimestamp
    private LocalDateTime dataHora;

}
