package com.sevenine.conecta.converter.atendimento;

import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.service.data.response.AtendimentoPreviewResponse;
import com.sevenine.conecta.service.data.response.AtendimentoProfissionalResponse;
import com.sevenine.conecta.service.data.response.PacienteResponse;
import com.sevenine.conecta.service.data.response.ProfissionalResponse;

import java.util.List;

public interface ConsultaAtendimentoPreviewConverter {
    List<AtendimentoPreviewResponse> fromListAtendimento(List<Atendimento> atendimentos, List<PacienteResponse> pacientes, List<AtendimentoProfissionalResponse> profissionais);
}
