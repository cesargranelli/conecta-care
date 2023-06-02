package com.sevenine.conecta.adapter.controller.data.request.tratamento;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EncerraTratamentoRequest {

    @NotNull(message = "O campo tratamentoId é obrigatório")
    private Long tratamentoId;

    @NotNull(message = "O campo observacao é obrigatório")
    private String observacao;

    @Valid
    @NotNull(message = "O campo situacao é obrigatório")
    private TratamentoSituacaoRequest situacao;

}
