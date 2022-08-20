package com.sevenine.conecta.controller.data.response.atendimento;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AtendimentoCheckResponse {

    private Long id;
    private Long profissionalId;
    private LocalDate data;
    private Long pacienteId;
    private String codigoSeguranca;

}
