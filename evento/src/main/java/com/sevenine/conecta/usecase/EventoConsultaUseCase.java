package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.response.EventoResponse;

public interface EventoConsultaUseCase {
    EventoResponse executar(long idEvento);
}
