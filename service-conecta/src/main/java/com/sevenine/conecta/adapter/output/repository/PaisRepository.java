package com.sevenine.conecta.adapter.output.repository;

import com.sevenine.conecta.adapter.output.entity.PaisData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<PaisData, Long> {
}
