package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.response.ExperienciaResponse;

import java.util.List;

public interface ConsultaExperienciaUseCase {
    List<ExperienciaResponse> executar(Long profissionalId);
}
