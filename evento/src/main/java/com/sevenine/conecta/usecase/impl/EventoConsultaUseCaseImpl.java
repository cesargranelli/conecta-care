package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.adapter.controller.data.response.EventoResponse;
import com.sevenine.conecta.services.EventoConsultaService;
import com.sevenine.conecta.usecase.EventoConsultaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EventoConsultaUseCaseImpl implements EventoConsultaUseCase {

    private final EventoConsultaService service;

    @Override
    public EventoResponse executar(long idEvento) {
        return service.consultar(idEvento);
    }

}
