package com.sevenine.conecta.services;

import com.sevenine.conecta.services.data.request.EventoEnviaRequest;

import java.util.List;

public interface EventoEnviaService {
    Integer enviar(List<EventoEnviaRequest> requestList);
}
