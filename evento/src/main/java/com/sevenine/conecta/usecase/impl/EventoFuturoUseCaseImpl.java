package com.connecta.evento.usecase.impl;

import com.connecta.evento.config.properties.ExceptionMessageProperties;
import com.connecta.evento.controller.data.response.EventoResponse;
import com.connecta.evento.exception.EventoNaoEncontradoException;
import com.connecta.evento.service.EventoEmAbertoService;
import com.connecta.evento.usecase.EventoFuturoUseCase;
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
