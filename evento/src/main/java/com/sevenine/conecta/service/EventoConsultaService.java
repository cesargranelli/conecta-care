package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.EventoResponse;

public interface EventoConsultaService {
    EventoResponse consultar(long idEvento);
}
