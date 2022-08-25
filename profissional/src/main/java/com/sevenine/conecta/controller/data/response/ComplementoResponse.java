package com.sevenine.conecta.controllers.data.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ComplementoResponse {
    private Long id;
    private Long tituloEleitoral;
    private String zonaEleitoral;
    private String secaoEleitoral;
    private Long numeroHabilitacao;
    private CategoriaCnhResponse categoriaCnh;
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
}
