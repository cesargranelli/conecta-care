package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controllers.data.response.ExperienciaResponse;
import com.sevenine.conecta.services.ConsultaExperienciaService;
import com.sevenine.conecta.usecase.ConsultaExperienciaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ConsultaExperienciaUseCaseImpl implements ConsultaExperienciaUseCase {

    private final ConsultaExperienciaService service;

    @Override
    public List<ExperienciaResponse> executar(Long profissionalId) {
        return service.consultar(profissionalId);
    }
}
