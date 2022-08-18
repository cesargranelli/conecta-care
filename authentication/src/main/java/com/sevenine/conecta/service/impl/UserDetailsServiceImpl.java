package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.http.data.request.CadastroUsuarioRequest;
import com.sevenine.conecta.repository.UsuarioRepository;
import com.sevenine.conecta.repository.data.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.sevenine.conecta.utils.converter.RoleConverter.rolesStringToRolesList;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository repository;
    private final Converter<CadastroUsuarioRequest, Usuario> usuarioRequestConverter;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = repository.findByEmail(email).orElse(null);
        if (Objects.isNull(usuario)) {
            throw new UsernameNotFoundException(email);
        }
        return new User(usuario.getEmail(), usuario.getPassword(), rolesStringToRolesList(usuario.getRoles()));
    }

}
