package com.sevenine.conecta.converter.atendimento;

import com.sevenine.conecta.controller.data.response.atendimento.AtendimentoResumoResponse;
import com.sevenine.conecta.service.data.response.PacienteResponse;

import java.util.List;

public interface ConsultaAtendimentoResumoConverter {
    List<AtendimentoResumoResponse> fromListAtendimentoPaciente(List<AtendimentoResumoResponse> atendimentos, List<PacienteResponse> pacientes);
}
