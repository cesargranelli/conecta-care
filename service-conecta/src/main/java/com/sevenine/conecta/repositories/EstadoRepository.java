package com.sevenine.conecta.repositories;

import com.sevenine.conecta.repositories.datas.EstadoData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<EstadoData, Long> {
}
