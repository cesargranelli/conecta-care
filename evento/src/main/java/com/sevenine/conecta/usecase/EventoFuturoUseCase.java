package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.response.EventoResponse;

import java.util.List;

public interface EventoFuturoUseCase {
    List<EventoResponse> executar();
}
