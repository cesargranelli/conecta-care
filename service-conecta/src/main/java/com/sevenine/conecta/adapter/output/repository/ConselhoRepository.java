package com.sevenine.conecta.adapter.output.repository;

import com.sevenine.conecta.adapter.output.entity.ConselhoData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConselhoRepository extends JpaRepository<ConselhoData, Long> {
}
