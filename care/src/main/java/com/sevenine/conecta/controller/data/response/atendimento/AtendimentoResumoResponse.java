package com.sevenine.conecta.controllers.data.response.atendimento;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class AtendimentoResumoResponse {
    private Long id;
    @JsonIgnore
    private Long pacienteId;
    private String nomePaciente;
    private String status;
    private LocalDate data;
    private LocalTime hora;
}
