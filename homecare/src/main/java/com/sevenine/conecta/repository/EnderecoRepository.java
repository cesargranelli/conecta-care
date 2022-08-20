package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Optional<Endereco> findByIdHomecare(Long idHomeCare);
}
