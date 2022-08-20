package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Table(name = "experiencias")
@Entity
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String empresa;
    private String cargo;
    private String observacao;
    private Integer posicao;
    private LocalDate dataAdmissao;
    private LocalDate dataDemissao;

    @ManyToOne
    private Profissional profissional;

}
