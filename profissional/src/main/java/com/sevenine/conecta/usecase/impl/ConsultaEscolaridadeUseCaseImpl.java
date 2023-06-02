package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.adapter.controller.data.response.EscolaridadeResponse;
import com.sevenine.conecta.services.ConsultaEscolaridadeService;
import com.sevenine.conecta.usecase.ConsultaEscolaridadeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ConsultaEscolaridadeUseCaseImpl implements ConsultaEscolaridadeUseCase {

    private final ConsultaEscolaridadeService service;

    @Override
    public EscolaridadeResponse executar(Long profissionalId) {
        return service.consultar(profissionalId);
    }

}
