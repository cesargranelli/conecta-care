package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.response.atendimento.AtendimentoPacienteResponse;

import java.time.LocalDate;
import java.util.List;

public interface ConsultaListaAtendimentoPacienteUseCase {
    List<AtendimentoPacienteResponse> executar(Long pacienteId, LocalDate dataConsulta);
}
