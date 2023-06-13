package com.sevenine.usuario.repository;

import com.sevenine.usuario.repository.data.SequenceCadastro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SequenceCadastroRepository extends JpaRepository<SequenceCadastro, Long> {
}
