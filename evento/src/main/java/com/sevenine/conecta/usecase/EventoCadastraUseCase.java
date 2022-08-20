package com.connecta.evento.usecase;

import com.connecta.evento.controller.data.request.EventoRequest;

public interface EventoCadastraUseCase {
    void executar(EventoRequest request);
}
