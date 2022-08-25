package com.sevenine.conecta.controllers.data.request.tratamento;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class TratamentoSituacaoRequest {

    @NotNull(message = "O campo datahora é obrigatório")
    private LocalDateTime dataHora;

    @NotNull(message = "O campo status é obrigatório")
    private String status;

}
