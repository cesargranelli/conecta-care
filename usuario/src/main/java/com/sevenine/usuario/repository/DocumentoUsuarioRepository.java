package com.sevenine.usuario.repository;

import com.sevenine.usuario.repository.data.DocumentoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentoUsuarioRepository extends JpaRepository<DocumentoUsuario, Long> {
    List<DocumentoUsuario> findByIdUsuario(long idUsuario);
}
