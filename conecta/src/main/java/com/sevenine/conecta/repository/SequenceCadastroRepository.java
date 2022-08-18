package com.sevenine.conecta.repository;

import com.sevenine.conecta.enumerator.Modulo;
import com.sevenine.conecta.repository.data.SequenceCadastro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SequenceCadastroRepository extends JpaRepository<SequenceCadastro, Long> {
    SequenceCadastro findByDocumentoAndModulo(String documento, Modulo modulo);
}
