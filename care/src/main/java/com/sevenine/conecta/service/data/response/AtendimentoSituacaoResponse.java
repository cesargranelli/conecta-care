package com.sevenine.conecta.service.data.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AtendimentoSituacaoResponse {
    private Long id;
    private StatusAtendimentoResponse status;
    private LocalDateTime dataHora;
}
