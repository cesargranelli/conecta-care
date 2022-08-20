package com.connecta.evento.service.state;

import com.connecta.evento.enumerator.EventoStatus;
import com.connecta.evento.repository.entity.Evento;

public interface EventoState {
    EventoStatus classificaStatus(Evento evento);
    void validaStatus(Evento evento);
}
