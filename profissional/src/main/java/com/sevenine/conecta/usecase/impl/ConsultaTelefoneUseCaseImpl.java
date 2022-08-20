package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controller.data.response.TelefoneResponse;
import com.sevenine.conecta.service.ConsultaTelefoneService;
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
