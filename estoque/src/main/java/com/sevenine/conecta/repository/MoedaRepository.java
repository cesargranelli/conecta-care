package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.MoedaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoedaRepository extends JpaRepository<MoedaData, Long> {
}
