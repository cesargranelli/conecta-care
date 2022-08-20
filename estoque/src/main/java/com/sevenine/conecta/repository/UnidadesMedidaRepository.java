package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.UnidadesMedidaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadesMedidaRepository extends JpaRepository<UnidadesMedidaData, Long> {
}
