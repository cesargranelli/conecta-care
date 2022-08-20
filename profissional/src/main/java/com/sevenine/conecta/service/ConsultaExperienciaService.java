package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.ExperienciaResponse;

import java.util.List;

public interface ConsultaExperienciaService {
    List<ExperienciaResponse> consultar(Long profissionalId);
}
