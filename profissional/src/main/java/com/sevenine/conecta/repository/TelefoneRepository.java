package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
    Optional<Telefone> findByProfissionalId(Long profissionalId);
}
