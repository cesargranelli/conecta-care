package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Table(name = "profissionais")
@Entity
public class ProfissionalPesquisa {

    @Id
    private Long id;

    private String cpf;
    private String nome;
    private String sobrenome;

}
