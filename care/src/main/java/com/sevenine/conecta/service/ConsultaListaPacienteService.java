package com.sevenine.conecta.services;

import com.sevenine.conecta.services.data.response.PacienteResponse;

import java.util.List;

public interface ConsultaListaPacienteService {
    List<PacienteResponse> consultar(List<Long> pacienteIdList);
}
