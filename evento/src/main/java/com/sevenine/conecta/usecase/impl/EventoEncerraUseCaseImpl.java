package com.connecta.evento.usecase.impl;

import com.connecta.evento.service.EventoEncerraService;
import com.connecta.evento.usecase.EventoEncerraUseCase;
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
