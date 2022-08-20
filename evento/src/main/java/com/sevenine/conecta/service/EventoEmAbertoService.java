package com.connecta.evento.service;

import com.connecta.evento.controller.data.response.EventoResponse;

import java.util.List;

public interface EventoEmAbertoService {
    List<EventoResponse> consultar();
}
