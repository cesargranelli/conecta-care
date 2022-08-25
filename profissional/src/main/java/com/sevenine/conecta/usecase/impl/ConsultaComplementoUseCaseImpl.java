package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controllers.data.response.ComplementoResponse;
import com.sevenine.conecta.services.ConsultaComplementoService;
import com.sevenine.conecta.usecase.ConsultaComplementoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ConsultaComplementoUseCaseImpl implements ConsultaComplementoUseCase {

    private final ConsultaComplementoService service;

    @Override
    public ComplementoResponse executar(Long profissionalId) {
        return service.consultar(profissionalId);
    }

}
