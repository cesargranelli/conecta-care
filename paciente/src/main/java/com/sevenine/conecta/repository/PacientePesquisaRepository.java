package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.entity.PacientePesquisaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PacientePesquisaRepository extends JpaRepository<PacientePesquisaEntity, Long> {

    @Query(value = "select p from PacientePesquisa p where trim(concat(p.nome, p.sobrenome)) like %:nome%")
    Optional<List<PacientePesquisaEntity>> findByNomeCompletoLike(@Param("nome") String nome);
}
