package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@DynamicUpdate
@Getter
@Setter
@Table(name = "enderecos")
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private String comprovante;

    @ManyToOne
    private Estado estado;

    @ManyToOne
    private Pais pais;

    @OneToOne
    private Profissional profissional;

}
