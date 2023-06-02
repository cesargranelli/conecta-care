package com.sevenine.conecta.adapter.controller.data.request.atendimento;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class AdicionaAtendimentoRequest {

    @NotNull(message = "O campo homeCareId é obrigatório")
    private Long homeCareId;

    @NotNull(message = "O campo tratamentoId é obrigatório")
    private Long tratamentoId;

    @NotNull(message = "O campo profissionalId é obrigatório")
    private Long profissionalId;

    private Long plantonistaId;
    private Long acompanhanteId;

    @NotNull(message = "O campo pacienteId é obrigatório")
    private Long pacienteId;

    @NotNull(message = "O campo data é obrigatório")
    private LocalDate data;

    @NotNull(message = "O campo hora é obrigatório")
    private LocalTime hora;

    @Valid
    @NotNull(message = "O objeto endereco é obrigatório")
    private EnderecoRequest endereco;

    private BigDecimal valorHomeCare;
    private BigDecimal valorProfissional;
    private BigDecimal valorPaciente;
    private BigDecimal valorAjudaCusto;
    private String observacao;
    private RecorrenciaRequest recorrencia;

    @Valid
    @NotNull(message = "O objeto situacao é obrigatório")
    private AdicionaAtendimentoSituacaoRequest situacao;

    private List<GrupoRequest> grupos;

    @Valid
    @NotNull(message = "O objeto tipoAtendimento é obrigatório")
    private TipoAtendimentoRequest tipoAtendimento;

}
