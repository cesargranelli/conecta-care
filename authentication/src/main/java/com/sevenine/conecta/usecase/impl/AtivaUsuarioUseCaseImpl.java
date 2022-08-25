package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.services.AtivaUsuarioService;
import com.sevenine.conecta.usecase.AtivaUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AtivaUsuarioUseCaseImpl implements AtivaUsuarioUseCase {

    private final AtivaUsuarioService ativaUsuarioService;

    @Override
    public void executar(Long profissionalId) {
        ativaUsuarioService.executar(profissionalId);
    }

}
