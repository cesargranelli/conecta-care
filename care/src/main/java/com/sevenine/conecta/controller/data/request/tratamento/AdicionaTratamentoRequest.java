package com.sevenine.conecta.controller.data.request.tratamento;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class AdicionaTratamentoRequest {

    @NotNull(message = "O campo descricao é obrigatório")
    private String descricao;

    @NotNull(message = "O campo valorKilometragem é obrigatório")
    private BigDecimal valorKilometragem;

    @NotNull(message = "O campo pacienteId é obrigatório")
    private Long pacienteId;

    private AdicionaAcompanhanteRequest acompanhante;

    @NotNull(message = "O campo profissionalId é obrigatório")
    private Long profissionalId;

    @NotNull(message = "O campo homeCareId é obrigatório")
    private Long homeCareId;

    @Valid
    @NotNull(message = "O objeto situacao é obrigatório")
    private TratamentoSituacaoRequest situacao;

    @JsonIgnore
    private Long acompanhanteId;

}
