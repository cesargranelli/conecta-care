package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "contas")
@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String agencia;
    private String numero;
    private String digito;
    private String chavePixPrimaria;
    private String chavePixSecundaria;

    @ManyToOne
    private Banco banco;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private TipoConta tipoConta;

    @OneToOne
    private Profissional profissional;

}
