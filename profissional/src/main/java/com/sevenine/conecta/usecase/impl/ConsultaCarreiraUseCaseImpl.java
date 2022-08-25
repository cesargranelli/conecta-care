package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controllers.data.response.CarreiraResponse;
import com.sevenine.conecta.services.ConsultaCarreiraService;
import com.sevenine.conecta.usecase.ConsultaCarreiraUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ConsultaCarreiraUseCaseImpl implements ConsultaCarreiraUseCase {

    private final ConsultaCarreiraService service;

    @Override
    public CarreiraResponse executar(Long profissionalId) {
        return service.consultar(profissionalId);
    }

}
