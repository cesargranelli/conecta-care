package com.sevenine.conecta.service.data.request.atendimento;

import com.sevenine.conecta.controller.data.request.atendimento.AdicionaAtendimentoSituacaoRequest;
import com.sevenine.conecta.controller.data.request.atendimento.CampoRequest;
import com.sevenine.conecta.controller.data.request.atendimento.EnderecoRequest;
import com.sevenine.conecta.controller.data.request.atendimento.RecorrenciaRequest;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class AdicionaAtendimentoServiceRequest {
    private Long homeCareId;
    private Long tratamentoId;
    private Long profissionalId;
    private Long plantonistaId;
    private Long acompanhanteId;
    private Long pacienteId;
    private LocalDate data;
    private LocalTime hora;
    private EnderecoRequest endereco;
    private BigDecimal valorHomeCare;
    private BigDecimal valorProfissional;
    private BigDecimal valorPaciente;
    private BigDecimal valorAjudaCusto;
    private List<CampoRequest> campos;
    private String observacao;
    private RecorrenciaRequest recorrencia;
    private AdicionaAtendimentoSituacaoRequest situacao;
}
