package com.sevenine.usuario.repository;

import com.sevenine.usuario.repository.data.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String username);

    Usuario findByEmailAndRolesContains(String email, String role);
}
