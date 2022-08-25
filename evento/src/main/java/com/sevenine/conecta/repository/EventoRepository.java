package com.sevenine.conecta.repository;

import com.sevenine.conecta.enumerator.EventoStatus;
import com.sevenine.conecta.repository.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    Optional<List<Evento>> findByStatus(EventoStatus eventoStatusAberto);
}
