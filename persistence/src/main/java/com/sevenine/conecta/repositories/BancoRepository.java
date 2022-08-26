package com.sevenine.conecta.repositories;

import com.sevenine.conecta.repositories.datas.BancoData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoRepository extends JpaRepository<BancoData, Long> {
}
