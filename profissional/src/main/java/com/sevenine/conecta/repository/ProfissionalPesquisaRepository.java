package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.ProfissionalPesquisa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProfissionalPesquisaRepository extends JpaRepository<ProfissionalPesquisa, Long> {

    @Query(value = "select p from ProfissionalPesquisa p where trim(concat(p.nome, p.sobrenome)) like %:nome%")
    Optional<List<ProfissionalPesquisa>> findByNomeCompletoLike(@Param("nome") String nome);

}
