package com.sevenine.conecta.controller.data.response.atendimento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtendimentoPacienteProtocoloResponse {
    private Long tratamentoId;
    private Long atendimentoId;
    private Long homeCareId;
    private Long profissionalId;
    private Long pacienteId;
    private String codigoSeguranca;
}
