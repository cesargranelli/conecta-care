package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.adapter.controller.data.response.EventoResponse;
import com.sevenine.conecta.enumerator.EventoStatus;
import com.sevenine.conecta.exception.EventoNaoEncontradoException;
import com.sevenine.conecta.repository.EventoRepository;
import com.sevenine.conecta.repository.entity.Evento;
import com.sevenine.conecta.services.EventoEmAbertoService;
import com.sevenine.conecta.mapper.EventoEmAbertoMapper;
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
