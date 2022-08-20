package com.sevenine.conecta.repository.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Table(name = "profissionais_complemento")
@Entity
public class Complemento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tituloEleitoral;
    private String zonaEleitoral;
    private String secaoEleitoral;
    private Long numeroHabilitacao;
    private LocalDate dataValidadeHabilitacao;
    private Long numeroReservista;
    private String nomeMae;
    private String profissaoMae;
    private String nomePai;
    private String profissaoPai;
    private String nomeConjuge;
    private String profissaoConjuge;
    private String fotoCnhFrente;
    private String fotoCnhVerso;

    private boolean carteiraVacinacao;

    @ManyToOne
    private CategoriaCnh categoriaCnh;

    @OneToOne
    private Profissional profissional;

}
