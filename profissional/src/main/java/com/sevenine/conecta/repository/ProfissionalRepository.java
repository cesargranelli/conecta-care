package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
    Optional<Profissional> findByCpf(String numeroCpf);
}
