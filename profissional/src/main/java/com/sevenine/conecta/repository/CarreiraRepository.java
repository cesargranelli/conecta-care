package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.Carreira;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarreiraRepository extends JpaRepository<Carreira, Long> {
    Optional<Carreira> findByProfissionalId(Long proprietarioId);
}
