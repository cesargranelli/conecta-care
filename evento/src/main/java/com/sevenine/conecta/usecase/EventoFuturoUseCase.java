package com.connecta.evento.usecase;

import com.connecta.evento.controller.data.response.EventoResponse;

import java.util.List;

public interface EventoFuturoUseCase {
    List<EventoResponse> executar();
}
