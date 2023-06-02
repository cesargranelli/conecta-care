package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.response.EventoResponse;

public interface EventoConsultaUseCase {
    EventoResponse executar(long idEvento);
}
