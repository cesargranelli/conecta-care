package com.sevenine.conecta.adapter.output.repository;

import com.sevenine.conecta.adapter.output.entity.BancoData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoRepository extends JpaRepository<BancoData, Long> {
}
