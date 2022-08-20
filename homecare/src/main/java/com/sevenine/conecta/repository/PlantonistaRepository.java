package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.Plantonista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlantonistaRepository extends JpaRepository<Plantonista, Long> {
    Optional<Plantonista> findByIdAndHomeCareId(Long plantonistaId, Long homeCareId);

    Optional<List<Plantonista>> findByIdIn(List<Long> ids);
}
