package com.sevenine.conecta.adapter.controller.data.request.atendimento;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class AdicionaAtendimentoSituacaoRequest {

    @NotNull(message = "O campo datahora é obrigatório")
    private LocalDateTime dataHora;

    @NotNull(message = "O campo status é obrigatório")
    private String status;

}
