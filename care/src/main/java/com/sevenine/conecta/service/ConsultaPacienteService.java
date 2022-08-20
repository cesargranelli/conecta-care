package com.sevenine.conecta.service;

import com.sevenine.conecta.service.data.response.PacienteResponse;

public interface ConsultaPacienteService {
    PacienteResponse consultar(Long pacienteId);
}
