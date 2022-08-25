package com.sevenine.conecta.converter.atendimento;

import com.sevenine.conecta.controllers.data.response.atendimento.AtendimentoPacienteResponse;
import com.sevenine.conecta.services.data.response.AtendimentoResponse;
import com.sevenine.conecta.services.data.response.AtendimentoProfissionalResponse;

import java.util.List;

public interface ConsultaListaAtendimentoPacienteUseCaseConverter {
    List<AtendimentoPacienteResponse> fromResponseService(List<AtendimentoResponse> atendimentos, List<AtendimentoProfissionalResponse> profissionais);
}
