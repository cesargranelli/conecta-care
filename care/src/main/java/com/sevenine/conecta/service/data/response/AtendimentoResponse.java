package com.sevenine.conecta.services.data.response;

import lombok.Getter;
import lombok.Setter;

import com.sevenine.conecta.adapter.controller.data.response.atendimento.TipoAtendimentoResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class AtendimentoResponse {
    private Long id;
    private String tipo;
    private LocalDate data;
    private LocalTime hora;
    private String observacao;
    private EnderecoResponse endereco;
    private Long tratamentoId;
    private Long plantonistaId;
    private RecorrenciaResponse recorrencia;
    private Long profissionalId;
    private ProcedimentoResponse procedimento;
    private BigDecimal valorHomeCare;
    private BigDecimal valorProfissional;
    private BigDecimal valorPaciente;
    private BigDecimal valorAjudaCusto;
    private Long homeCareId;
    private Long pacienteId;
    private List<CampoResponse> campos;
    private List<GrupoResponse> grupos;
    private List<AtendimentoSituacaoResponse> situacoes;
    private String codigoSeguranca;
    
    @JsonIgnore
    private String assinatura;
    @JsonIgnore
    private TipoAtendimentoResponse tipoAtendimentoResponse;
    
}
