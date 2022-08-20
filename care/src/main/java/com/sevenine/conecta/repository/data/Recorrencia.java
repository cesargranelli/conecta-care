package com.sevenine.conecta.repository.data;

import com.sevenine.conecta.enumerator.RepeticaoEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Table(name = "recorrencias")
@Entity
public class Recorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate inicio;
    private LocalDate fim;
    private Integer quantidade;

    @Enumerated(EnumType.STRING)
    private RepeticaoEnum repeticao;

    @OneToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "recorrencia_id"),
            inverseJoinColumns = @JoinColumn(name = "semana_id")
    )
    private List<Semana> semanas;

}
