package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {

    Optional<EnderecoEntity> findByIdPaciente(Long idPaciente);
}
