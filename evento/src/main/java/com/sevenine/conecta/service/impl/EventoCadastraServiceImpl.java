package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.controllers.data.request.EventoRequest;
import com.sevenine.conecta.mapper.EventoCadastraMapper;
import com.sevenine.conecta.repository.EventoRepository;
import com.sevenine.conecta.repository.entity.Evento;
import com.sevenine.conecta.services.EventoCadastraService;
import com.sevenine.conecta.services.state.evento.EventoAberto;
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
