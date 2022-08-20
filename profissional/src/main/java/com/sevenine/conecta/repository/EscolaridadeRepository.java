package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.Escolaridade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EscolaridadeRepository extends JpaRepository<Escolaridade, Long> {
    Optional<Escolaridade> findByProfissionalId(Long profissionalId);
}
