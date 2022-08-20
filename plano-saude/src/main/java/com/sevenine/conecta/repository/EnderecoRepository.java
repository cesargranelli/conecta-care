package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Endereco findByIdPlanoSaude(Long idPlanoSaude);
}
