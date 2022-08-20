package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.LocacaoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoRepository extends JpaRepository<LocacaoData, Long> {
}
