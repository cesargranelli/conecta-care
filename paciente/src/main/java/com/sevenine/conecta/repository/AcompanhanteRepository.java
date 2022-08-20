package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.entity.AcompanhanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AcompanhanteRepository extends JpaRepository<AcompanhanteEntity, Long> {
    Optional<AcompanhanteEntity> findByPacienteIdAndId(Long pacienteId, Long acompanhanteId);

    Optional<List<AcompanhanteEntity>> findByPacienteId(Long acompanhantesIds);

    Optional<AcompanhanteEntity> findByCpfAndPacienteId(String cpf, Long pacienteId);
}
