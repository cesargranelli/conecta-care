package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.services.EventoEncerraService;
import com.sevenine.conecta.usecase.EventoEncerraUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EventoEncerraUseCaseImpl implements EventoEncerraUseCase {

    private final EventoEncerraService eventoEncerraService;

    @Override
    public void executar(long idEvento, String usuario) {
        eventoEncerraService.encerrar(idEvento, usuario);
    }

}
