package com.sevenine.conecta.services.state;

import com.sevenine.conecta.enumerator.EventoStatus;
import com.sevenine.conecta.repository.entity.Evento;

public interface EventoState {
    EventoStatus classificaStatus(Evento evento);
    void validaStatus(Evento evento);
}
