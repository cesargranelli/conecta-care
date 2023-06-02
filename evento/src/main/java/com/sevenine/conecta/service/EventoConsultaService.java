package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.EventoResponse;

public interface EventoConsultaService {
    EventoResponse consultar(long idEvento);
}
