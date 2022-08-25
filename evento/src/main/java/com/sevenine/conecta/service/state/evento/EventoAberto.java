package com.sevenine.conecta.services.state.evento;

import com.sevenine.conecta.enumerator.EventoStatus;
import com.sevenine.conecta.repository.entity.Evento;
import com.sevenine.conecta.services.state.EventoState;

public class EventoAberto implements EventoState {

    @Override
    public EventoStatus classificaStatus(Evento evento) {
        return EventoStatus.ABERTO;
    }

    @Override
    public void validaStatus(Evento evento) {
    }

}
