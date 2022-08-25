package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controllers.data.response.TelefoneResponse;
import com.sevenine.conecta.services.ConsultaTelefoneService;
import com.sevenine.conecta.usecase.ConsultaTelefoneUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ConsultaTelefoneUseCaseImpl implements ConsultaTelefoneUseCase {

    private final ConsultaTelefoneService service;

    @Override
    public TelefoneResponse executar(Long profissionalId) {
        return service.consultar(profissionalId);
    }
}
