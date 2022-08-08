package com.sevenine.conecta.repository;

import com.sevenine.conecta.enumerator.Modulo;
import com.sevenine.conecta.repository.data.SequenceCadastro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SequenceCadastroRepository extends JpaRepository<SequenceCadastro, Long> {
    Optional<SequenceCadastro> findById(Long id);

    SequenceCadastro findByDocumentoAndModulo(String documento, Modulo modulo);
}
