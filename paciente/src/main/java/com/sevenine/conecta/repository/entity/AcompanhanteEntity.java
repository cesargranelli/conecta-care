package com.sevenine.conecta.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Table(name = "acompanhantes")
@Entity
public class AcompanhanteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;

    @OneToOne
    private GeneroEntity genero;

    @OneToOne
    private ParentescoEntity parentesco;

    @OneToOne(cascade = CascadeType.ALL)
    private ContatoEntity contato;

    private Long pacienteId;

}
