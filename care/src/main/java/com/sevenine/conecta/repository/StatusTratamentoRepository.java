package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.StatusTratamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusTratamentoRepository extends JpaRepository<StatusTratamento, Long> {
    StatusTratamento findByDescricao(String status);
}
