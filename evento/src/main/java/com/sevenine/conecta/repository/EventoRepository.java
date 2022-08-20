package com.connecta.evento.repository;

import com.connecta.evento.enumerator.EventoStatus;
import com.connecta.evento.repository.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    Optional<List<Evento>> findByStatus(EventoStatus eventoStatusAberto);
}
