package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.repository.UsuarioRepository;
import com.sevenine.conecta.repository.data.Usuario;
import com.sevenine.conecta.services.ConsultaUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ConsultaUsuarioServiceImpl implements ConsultaUsuarioService {

    private final UsuarioRepository repository;

    @Override
    public Usuario buscarUsuario(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
    }

}
