package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.VendaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<VendaData, Long> {
}
