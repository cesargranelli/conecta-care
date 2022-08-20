package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.ListaProfissional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ListaProfissionalRepository extends JpaRepository<ListaProfissional, Long> {
    Optional<List<ListaProfissional>> findByIdIn(List<Long> profissionaisIds);
}
