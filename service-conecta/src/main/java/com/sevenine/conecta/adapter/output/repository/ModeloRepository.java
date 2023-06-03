package com.sevenine.conecta.adapter.output.repository;

import com.sevenine.conecta.adapter.output.entity.ModeloData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<ModeloData, Long> {
}
