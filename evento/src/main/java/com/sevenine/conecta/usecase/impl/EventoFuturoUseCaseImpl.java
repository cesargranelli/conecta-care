package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.adapter.controller.data.response.EventoResponse;
import com.sevenine.conecta.exception.EventoNaoEncontradoException;
import com.sevenine.conecta.services.EventoEmAbertoService;
import com.sevenine.conecta.usecase.EventoFuturoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class EventoFuturoUseCaseImpl implements EventoFuturoUseCase {

    private final ExceptionMessageProperties exceptionMessageProperties;

    private final EventoEmAbertoService eventoEmAbertoService;

    @Override
    public List<EventoResponse> executar() {
        List<EventoResponse> eventosEmAberto = eventoEmAbertoService.consultar();

        List<EventoResponse> eventoResponseList = eventosEmAberto.stream()
                .filter(evento -> evento.getData().isAfter(LocalDate.now()))
                .collect(Collectors.toList());

        if (eventoResponseList.size() == 0) {
            throw new EventoNaoEncontradoException(
                    exceptionMessageProperties.getEventoNaoEncontrado(), HttpStatus.NOT_FOUND
            );
        }

        return eventoResponseList;
    }

}
