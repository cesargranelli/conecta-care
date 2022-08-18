package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.DocumentoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentoUsuarioRepository extends JpaRepository<DocumentoUsuario, Long> {
    List<DocumentoUsuario> findByIdUsuario(long idUsuario);
}
