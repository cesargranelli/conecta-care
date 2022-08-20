package com.connecta.evento.service.impl;

import com.connecta.evento.config.properties.ExceptionMessageProperties;
import com.connecta.evento.exception.FalhaEncerrarEventoException;
import com.connecta.evento.repository.EventoRepository;
import com.connecta.evento.repository.entity.Evento;
import com.connecta.evento.service.EventoEncerraService;
import com.connecta.evento.service.state.evento.EventoEncerrado;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EventoEncerraServiceImpl implements EventoEncerraService {

    private final ExceptionMessageProperties exceptionMessageProperties;

    private final EventoRepository repository;

    @Override
    public void encerrar(long idEvento, String usuarioAtualizacao) {
        Optional<Evento> optional = repository.findById(idEvento);

        Evento evento = optional.orElseThrow(() -> new FalhaEncerrarEventoException(
                exceptionMessageProperties.getFalhaEncerrarEvento(), HttpStatus.UNPROCESSABLE_ENTITY));

        evento.setUsuarioAtualizacao(usuarioAtualizacao);
        evento.setDataAtualizacao(LocalDateTime.now());
        evento.classificaStatus(new EventoEncerrado());

        repository.flush();
    }

}
