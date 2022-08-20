package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controller.data.response.EscolaridadeResponse;
import com.sevenine.conecta.service.ConsultaEscolaridadeService;
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
