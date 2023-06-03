package com.sevenine.conecta.adapter.output.repository;

import com.sevenine.conecta.adapter.output.entity.EstadoData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<EstadoData, Long> {
}
