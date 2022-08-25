package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.exception.FalhaEncerrarEventoException;
import com.sevenine.conecta.repository.EventoRepository;
import com.sevenine.conecta.repository.entity.Evento;
import com.sevenine.conecta.services.EventoEncerraService;
import com.sevenine.conecta.services.state.evento.EventoEncerrado;
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
