package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.StatusAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StatusAtendimentoRepository extends JpaRepository<StatusAtendimento, Long> {

    @Query(value = "SELECT * FROM status_atendimento WHERE descricao = :status", nativeQuery = true)
    Optional<StatusAtendimento> findByStatusEnum(@Param("status") String status);

    StatusAtendimento findByDescricao(String status);
}
