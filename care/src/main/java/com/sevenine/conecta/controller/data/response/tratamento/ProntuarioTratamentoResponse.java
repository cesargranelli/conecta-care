package com.sevenine.conecta.controller.data.response.tratamento;

import com.sevenine.conecta.service.data.response.ProntuarioProfissionalResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProntuarioTratamentoResponse {
    private Long id;
    private String descricao;
    private ProntuarioProfissionalResponse profissional;
    private List<ProntuarioAtendimentoResponse> atendimentos;
    private ProntuarioTratamentoSituacaoResponse situacao;
}
