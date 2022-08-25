package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.controllers.data.response.EventoResponse;
import com.sevenine.conecta.exception.EventoNaoEncontradoException;
import com.sevenine.conecta.repository.EventoRepository;
import com.sevenine.conecta.repository.entity.Evento;
import com.sevenine.conecta.services.EventoConsultaService;
import com.sevenine.conecta.mapper.EventoConsultaMapper;
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
