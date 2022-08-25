package com.sevenine.conecta.services.state.evento;

import com.sevenine.conecta.enumerator.EventoStatus;
import com.sevenine.conecta.exception.FalhaValidacaoStatusEventoException;
import com.sevenine.conecta.repository.entity.Evento;
import com.sevenine.conecta.services.state.EventoState;
import org.springframework.http.HttpStatus;

import static java.util.Objects.isNull;

public class EventoEncerrado implements EventoState {

    @Override
    public EventoStatus classificaStatus(Evento evento) {
        validaStatus(evento);
        return EventoStatus.ENCERRADO;
    }

    @Override
    public void validaStatus(Evento evento) {
        if (isNull(evento.getStatus()) || !evento.getStatus().equals(EventoStatus.ABERTO)) {
            throw new FalhaValidacaoStatusEventoException(
                    String.format("O evento só pode ser ENCERRADO se ainda estiver com status ABERTO. Status atual é %s", evento.getStatus().name()),
                    HttpStatus.PRECONDITION_FAILED
            );
        }
    }

}
