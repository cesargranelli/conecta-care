package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.adapter.controller.data.request.EventoRequest;
import com.sevenine.conecta.services.EventoCadastraService;
import com.sevenine.conecta.usecase.EventoCadastraUseCase;
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
