package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controller.data.response.ContaResponse;
import com.sevenine.conecta.service.ConsultaContaService;
import com.sevenine.conecta.usecase.ConsultaContaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ConsultaContaUseCaseImpl implements ConsultaContaUseCase {

    private final ConsultaContaService service;

    @Override
    public ContaResponse executar(Long profissionalId) {
        return service.consultar(profissionalId);
    }
}
