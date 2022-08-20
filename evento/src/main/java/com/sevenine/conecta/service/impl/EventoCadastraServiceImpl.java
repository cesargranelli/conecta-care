package com.connecta.evento.service.impl;

import com.connecta.evento.controller.data.request.EventoRequest;
import com.connecta.evento.mapper.EventoCadastraMapper;
import com.connecta.evento.repository.EventoRepository;
import com.connecta.evento.repository.entity.Evento;
import com.connecta.evento.service.EventoCadastraService;
import com.connecta.evento.service.state.evento.EventoAberto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EventoCadastraServiceImpl implements EventoCadastraService {

    private final EventoCadastraMapper mapper;

    private final EventoRepository repository;

    @Override
    public void cadastrar(EventoRequest request) {
        Evento evento = mapper.toEntityData(request);
        evento.classificaStatus(new EventoAberto());
        repository.save(evento);
    }

}
