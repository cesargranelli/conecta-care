package com.connecta.evento.service;

import com.connecta.evento.controller.data.request.EventoRequest;

public interface EventoCadastraService {
    void cadastrar(EventoRequest request);
}
