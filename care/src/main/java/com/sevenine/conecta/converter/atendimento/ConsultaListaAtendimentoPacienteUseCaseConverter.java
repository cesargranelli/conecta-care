package com.sevenine.conecta.converter.atendimento;

import com.sevenine.conecta.controller.data.response.atendimento.AtendimentoPacienteResponse;
import com.sevenine.conecta.service.data.response.AtendimentoResponse;
import com.sevenine.conecta.service.data.response.AtendimentoProfissionalResponse;

import java.util.List;

public interface ConsultaListaAtendimentoPacienteUseCaseConverter {
    List<AtendimentoPacienteResponse> fromResponseService(List<AtendimentoResponse> atendimentos, List<AtendimentoProfissionalResponse> profissionais);
}
