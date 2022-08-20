package com.sevenine.conecta.controller.data.response.tratamento;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class ConsultaTratamentoAtendimentoResponse {
    private Long id;
    private LocalDate data;
    private LocalTime hora;
    private String nomeProfissional;
    private ConsultaAtendimentoSituacaoResponse situacao;
    private String descricaoProcedimento;
    private String descricaoMedicamento;
    private String descricaoEquipamento;
}
