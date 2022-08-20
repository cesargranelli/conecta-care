package com.sevenine.conecta.repository.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "contatos")
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class ContatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "telefone_fixo", length = 13)
    private String telefoneFixo;

    @Column(name = "telefone_recado", length = 13)
    private String telefoneRecado;

    @Column(name = "telefone_celular", length = 13)
    private String telefoneCelular;

    @Column(name = "telefone_responsavel", length = 13)
    private String telefoneResponsavel;

    @Column(name = "email_responsavel", length = 13)
    private String emailResponsavel;

}
