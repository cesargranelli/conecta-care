package com.sevenine.conecta.service;

import com.sevenine.conecta.service.data.response.AtendimentoResponse;

import java.util.List;

public interface ConsultaListaAtendimentoPacienteService {
    List<AtendimentoResponse> consultar(Long pacienteId);
}
