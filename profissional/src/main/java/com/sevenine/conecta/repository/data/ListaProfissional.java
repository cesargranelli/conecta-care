package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "profissionais")
@Entity
public class ListaProfissional {

    @Id
    private Long id;

    private String cpf;
    private String nome;
    private String sobrenome;
    private String fotoProfissional;

    @OneToOne
    private TipoEmpresa tipoEmpresa;

    @OneToOne
    private EstadoCivil estadoCivil;

    @OneToOne(mappedBy = "profissional")
    private Carreira carreira;

    @OneToOne(mappedBy = "profissional")
    private Telefone telefone;

}
