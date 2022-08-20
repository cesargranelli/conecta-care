package com.sevenine.conecta.service;

import com.sevenine.conecta.service.data.response.PacienteResponse;

import java.util.List;

public interface ConsultaListaPacienteService {
    List<PacienteResponse> consultar(List<Long> pacienteIdList);
}
