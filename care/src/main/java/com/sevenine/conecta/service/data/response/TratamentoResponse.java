package com.sevenine.conecta.service.data.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class TratamentoResponse {
    private Long id;
    private String descricao;
    private BigDecimal valorKilometragem;
    private PacienteResponse paciente;
    private AcompanhanteResponse acompanhante;
    private AtendimentoProfissionalResponse profissional;
    private HomeCareResponse homeCare;
    private List<AtendimentoDetalheResponse> atendimentos;
    private List<TratamentoSituacaoResponse> situacoes;
}
