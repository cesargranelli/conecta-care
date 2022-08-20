package com.connecta.evento.usecase.impl;

import com.connecta.evento.controller.data.response.EventoResponse;
import com.connecta.evento.service.EventoConsultaService;
import com.connecta.evento.usecase.EventoConsultaUseCase;
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
