package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.Complemento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComplementoRepository extends JpaRepository<Complemento, Long> {
    Optional<Complemento> findByProfissionalId(Long profissionalId);
}
