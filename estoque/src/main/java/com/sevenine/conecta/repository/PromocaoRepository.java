package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.PromocaoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocaoRepository extends JpaRepository<PromocaoData, Long> {
}
