package com.sevenine.conecta.services;

import com.sevenine.conecta.services.data.response.AtendimentoResponse;

import java.util.List;

public interface ConsultaListaAtendimentoPacienteService {
    List<AtendimentoResponse> consultar(Long pacienteId);
}
