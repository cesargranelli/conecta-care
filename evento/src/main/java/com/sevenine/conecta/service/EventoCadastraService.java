package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.request.EventoRequest;

public interface EventoCadastraService {
    void cadastrar(EventoRequest request);
}
