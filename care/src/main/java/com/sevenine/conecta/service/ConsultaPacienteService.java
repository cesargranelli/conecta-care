package com.sevenine.conecta.services;

import com.sevenine.conecta.services.data.response.PacienteResponse;

public interface ConsultaPacienteService {
    PacienteResponse consultar(Long pacienteId);
}
