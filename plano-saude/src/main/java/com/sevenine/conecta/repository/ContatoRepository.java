package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    Optional<Contato> findByIdPlanoSaude(Long proprietarioId);
}
