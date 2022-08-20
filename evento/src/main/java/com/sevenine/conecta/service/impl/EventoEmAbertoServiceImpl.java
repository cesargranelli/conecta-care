package com.connecta.evento.service.impl;

import com.connecta.evento.config.properties.ExceptionMessageProperties;
import com.connecta.evento.controller.data.response.EventoResponse;
import com.connecta.evento.enumerator.EventoStatus;
import com.connecta.evento.exception.EventoNaoEncontradoException;
import com.connecta.evento.repository.EventoRepository;
import com.connecta.evento.repository.entity.Evento;
import com.connecta.evento.service.EventoEmAbertoService;
import com.connecta.evento.mapper.EventoEmAbertoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EventoEmAbertoServiceImpl implements EventoEmAbertoService {

    private final ExceptionMessageProperties exceptionMessageProperties;

    private final EventoEmAbertoMapper mapper;

    private final EventoRepository repository;

    @Override
    public List<EventoResponse> consultar() {
        Optional<List<Evento>> optionalList = repository.findByStatus(EventoStatus.ABERTO);

        return mapper.fromEntityData(optionalList.orElseThrow(() -> new EventoNaoEncontradoException(
                exceptionMessageProperties.getEventoNaoEncontrado(), HttpStatus.NOT_FOUND)));
    }

}
