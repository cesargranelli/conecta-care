package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "contatos")
@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "telefone_fixo")
    private String telefoneFixo;

    @Column(name = "telefone_recado")
    private String telefoneRecado;

    @Column(name = "telefone_celular")
    private String celularPrincipal;

    @Column(name = "telefone_whatsapp")
    private String celularSecundario;

    @OneToOne
    private Profissional profissional;

}
