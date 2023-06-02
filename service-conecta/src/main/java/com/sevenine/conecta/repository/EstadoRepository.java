package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.datas.EstadoData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<EstadoData, Long> {
}
