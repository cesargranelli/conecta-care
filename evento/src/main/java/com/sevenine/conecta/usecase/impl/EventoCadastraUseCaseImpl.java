package com.connecta.evento.usecase.impl;

import com.connecta.evento.controller.data.request.EventoRequest;
import com.connecta.evento.service.EventoCadastraService;
import com.connecta.evento.usecase.EventoCadastraUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EventoCadastraUseCaseImpl implements EventoCadastraUseCase {

    private final EventoCadastraService eventoCadastraService;

    @Override
    public void executar(EventoRequest request) {
        eventoCadastraService.cadastrar(request);
    }

}
