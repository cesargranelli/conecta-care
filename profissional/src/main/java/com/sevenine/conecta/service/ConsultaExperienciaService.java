package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.ExperienciaResponse;

import java.util.List;

public interface ConsultaExperienciaService {
    List<ExperienciaResponse> consultar(Long profissionalId);
}
