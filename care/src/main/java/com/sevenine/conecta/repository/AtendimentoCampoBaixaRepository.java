package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.AtendimentoCampoBaixa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoCampoBaixaRepository extends JpaRepository<AtendimentoCampoBaixa, Long> {
    Optional<AtendimentoCampoBaixa> findByAtendimentoIdAndCampoId(Long atendimentoId, Long campoId);
}
