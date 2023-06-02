package com.sevenine.conecta.adapter.controller.data.response.tratamento;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ConsultaTratamentoResponse {
    private Long id;
    private String descricao;
    private BigDecimal valorKilometragem;
    private ConsultaTratamentoPacienteResponse paciente;
    private ConsultaTratamentoAcompanhanteResponse acompanhante;
    private ConsultaTratamentoProfissionalResponse profissional;
    private List<ConsultaTratamentoAtendimentoResponse> atendimentos;
    private ConsultaTratamentoSituacaoResponse situacao;
}
