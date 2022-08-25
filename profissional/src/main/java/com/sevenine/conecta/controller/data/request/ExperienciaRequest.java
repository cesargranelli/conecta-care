package com.sevenine.conecta.controllers.data.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ExperienciaRequest {
    private Long profissionalId;
    private Integer posicao;
    private String empresa;
    private String cargo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAdmissao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDemissao;
    private String observacao;
}
