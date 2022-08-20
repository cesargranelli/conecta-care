package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.EstoqueData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueData, Long> {
}
