package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    Optional<Conta> findByProfissionalId(Long profissionalId);
}
