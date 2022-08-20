package com.sevenine.conecta.service;

import com.sevenine.conecta.service.data.response.AcompanhanteResponse;

public interface ConsultaAcompanhanteService {
    AcompanhanteResponse consultar(Long pacienteId, Long acompanhanteId);
}
