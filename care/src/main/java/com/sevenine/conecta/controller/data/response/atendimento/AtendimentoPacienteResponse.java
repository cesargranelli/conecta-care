package com.sevenine.conecta.controllers.data.response.atendimento;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class AtendimentoPacienteResponse {
    private Long id;
    private LocalDate data;
    private LocalTime hora;
    private String status;
    private String nomeProfissional;
    private String registroProfissional;
    private AtendimentoPacienteProtocoloResponse protocolo;
}
