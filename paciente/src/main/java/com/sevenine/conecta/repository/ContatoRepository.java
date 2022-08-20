package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.entity.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<ContatoEntity, Long> {
}
