package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {

    Optional<PacienteEntity> findByCpf(String cpf);

    @Query(value = "select p from Paciente p where trim(concat(p.nome, p.sobrenome)) like %:nome%")
    Optional<List<PacienteEntity>> findByNomeCompletoLike(@Param("nome") String nome);

    Optional<List<PacienteEntity>> findByIdIn(List<Long> idsPacientes);
}
