package com.connecta.evento.service.state.evento;

import com.connecta.evento.enumerator.EventoStatus;
import com.connecta.evento.repository.entity.Evento;
import com.connecta.evento.service.state.EventoState;

public class EventoAberto implements EventoState {

    @Override
    public EventoStatus classificaStatus(Evento evento) {
        return EventoStatus.ABERTO;
    }

    @Override
    public void validaStatus(Evento evento) {
    }

}
