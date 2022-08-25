package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controllers.data.response.EnderecoResponse;
import com.sevenine.conecta.services.ConsultaEnderecoService;
import com.sevenine.conecta.usecase.ConsultaEnderecoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ConsultaEnderecoUseCaseImpl implements ConsultaEnderecoUseCase {

    private final ConsultaEnderecoService service;

    @Override
    public EnderecoResponse executar(Long profissionalId) {
        return service.consultar(profissionalId);
    }

}
