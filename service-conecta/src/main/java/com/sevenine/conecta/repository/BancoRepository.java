package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.datas.BancoData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoRepository extends JpaRepository<BancoData, Long> {
}
