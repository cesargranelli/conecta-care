package com.connecta.evento.service;

import com.connecta.evento.service.data.request.EventoEnviaRequest;

import java.util.List;

public interface EventoEnviaService {
    Integer enviar(List<EventoEnviaRequest> requestList);
}
