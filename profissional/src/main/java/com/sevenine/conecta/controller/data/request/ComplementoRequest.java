package com.sevenine.conecta.controllers.data.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ComplementoRequest {
    private Long id;
    private Long tituloEleitoral;
    private String zonaEleitoral;
    private String secaoEleitoral;
    private Long numeroHabilitacao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataValidadeHabilitacao;

    private Long categoriaCNH;
    private String fotoCNHFrente;
    private String fotoCNHVerso;
    private Long numeroReservista;
    private String nomeMae;
    private String profissaoMae;
    private String nomePai;
    private String profissaoPai;
    private String nomeConjuge;
    private String profissaoConjuge;
    private boolean carteiraVacinacao;
    private Long proprietarioId;

}
