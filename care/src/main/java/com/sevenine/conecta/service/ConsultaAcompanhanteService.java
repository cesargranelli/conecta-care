package com.sevenine.conecta.services;

import com.sevenine.conecta.services.data.response.AcompanhanteResponse;

public interface ConsultaAcompanhanteService {
    AcompanhanteResponse consultar(Long pacienteId, Long acompanhanteId);
}
