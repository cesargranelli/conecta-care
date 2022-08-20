package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.CategoriaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaData, Long> {
}
