package com.connecta.evento.service;

import com.connecta.evento.controller.data.response.EventoResponse;

public interface EventoConsultaService {
    EventoResponse consultar(long idEvento);
}
