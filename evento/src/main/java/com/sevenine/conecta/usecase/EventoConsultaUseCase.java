package com.connecta.evento.usecase;

import com.connecta.evento.controller.data.response.EventoResponse;

public interface EventoConsultaUseCase {
    EventoResponse executar(long idEvento);
}
