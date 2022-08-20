package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.EnderecoHomecare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<EnderecoHomecare, Long> {
    Optional<EnderecoHomecare> findByHomecareId(Long idHomeCare);
}
