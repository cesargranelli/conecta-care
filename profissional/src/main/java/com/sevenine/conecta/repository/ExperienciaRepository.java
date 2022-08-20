package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {

    Optional<List<Experiencia>> findByProfissionalId(Long profissionalId);

    @Transactional
    void deleteByProfissionalId(Long proprietarioId);

}
