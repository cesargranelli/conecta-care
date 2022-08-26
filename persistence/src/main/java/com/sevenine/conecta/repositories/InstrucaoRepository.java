package com.sevenine.conecta.repositories;

import com.sevenine.conecta.repositories.datas.InstrucaoData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrucaoRepository extends JpaRepository<InstrucaoData, Long> {
}
