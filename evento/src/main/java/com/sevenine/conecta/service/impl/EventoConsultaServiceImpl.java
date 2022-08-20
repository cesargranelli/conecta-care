package com.connecta.evento.service.impl;

import com.connecta.evento.config.properties.ExceptionMessageProperties;
import com.connecta.evento.controller.data.response.EventoResponse;
import com.connecta.evento.exception.EventoNaoEncontradoException;
import com.connecta.evento.repository.EventoRepository;
import com.connecta.evento.repository.entity.Evento;
import com.connecta.evento.service.EventoConsultaService;
import com.connecta.evento.mapper.EventoConsultaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EventoConsultaServiceImpl implements EventoConsultaService {

    private final ExceptionMessageProperties exceptionMessageProperties;

    private final EventoConsultaMapper mapper;

    private final EventoRepository repository;

    @Override
    public EventoResponse consultar(long idEvento) {
        Optional<Evento> optional = repository.findById(idEvento);

        return mapper.fromEntityData(optional.orElseThrow(() -> new EventoNaoEncontradoException(
                exceptionMessageProperties.getEventoNaoEncontrado(), HttpStatus.NOT_FOUND)));
    }

}
