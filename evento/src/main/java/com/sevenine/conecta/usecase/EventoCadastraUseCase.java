package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.request.EventoRequest;

public interface EventoCadastraUseCase {
    void executar(EventoRequest request);
}
