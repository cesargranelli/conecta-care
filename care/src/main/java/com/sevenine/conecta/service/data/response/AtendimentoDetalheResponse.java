package com.sevenine.conecta.services.data.response;

import com.sevenine.conecta.controllers.data.response.atendimento.TipoAtendimentoResponse;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class AtendimentoDetalheResponse {
    private Long id;
    private LocalDate data;
    private LocalTime hora;
    private String protocolo;
    private String observacao;
    private PacienteResponse paciente;
    private EnderecoResponse endereco;
    private PlantonistaResponse plantonista;
    private RecorrenciaResponse recorrencia;
    private AtendimentoProfissionalResponse profissional;
    private BigDecimal valorHomeCare;
    private BigDecimal valorProfissional;
    private BigDecimal valorPaciente;
    private BigDecimal valorAjudaCusto;
    private List<GrupoResponse> grupos;
    private List<AtendimentoSituacaoResponse> situacoes;
    private ProcedimentoResponse procedimento;
    private TratamentoResponse tratamento;
    private TipoAtendimentoResponse tipoAtendimento;
}
