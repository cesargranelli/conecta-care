package com.sevenine.conecta.adapter.output.repository;

import com.sevenine.conecta.adapter.output.entity.InstrucaoData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrucaoRepository extends JpaRepository<InstrucaoData, Long> {
}
