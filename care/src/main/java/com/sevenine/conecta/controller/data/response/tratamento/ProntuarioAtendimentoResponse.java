package com.sevenine.conecta.controllers.data.response.tratamento;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class ProntuarioAtendimentoResponse {
    private Long id;
    private LocalDate data;
    private LocalTime hora;
    private String nomeProfissional;
    private String descricaoProcedimento;
    private String descricaoMedicamento;
    private String descricaoEquipamento;
}
