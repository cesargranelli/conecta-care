package com.sevenine.conecta.services.data.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TratamentoSituacaoResponse {
    private Long id;
    private StatusTratamentoResponse status;
    private LocalDateTime dataHora;
}
