package com.sevenine.conecta.adapter.output.repository;

import com.sevenine.conecta.adapter.output.entity.TransporteData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransporteRepository extends JpaRepository<TransporteData, Long> {
}
