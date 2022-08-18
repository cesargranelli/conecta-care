package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String username);

    Usuario findByEmailAndRolesContains(String email, String role);
}
