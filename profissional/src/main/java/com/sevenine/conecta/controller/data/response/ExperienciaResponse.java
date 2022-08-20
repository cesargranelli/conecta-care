package com.sevenine.conecta.controller.data.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ExperienciaResponse {
    private Long id;
    private String empresa;
    private String cargo;
    private LocalDate dataAdmissao;
    private LocalDate dataDemissao;
    private String observacao;
    private Integer posicao;
}
