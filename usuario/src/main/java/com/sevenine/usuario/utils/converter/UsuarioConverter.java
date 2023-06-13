package com.sevenine.usuario.utils.converter;

import com.sevenine.usuario.adapter.controller.data.request.CadastroUsuarioRequest;
import com.sevenine.usuario.repository.data.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Component
public class UsuarioConverter implements Converter<CadastroUsuarioRequest, Usuario> {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Usuario convert(CadastroUsuarioRequest source) {

        Usuario usuario = new Usuario();
        usuario.setEmail(source.getEmail());
        usuario.setPassword(bCryptPasswordEncoder.encode(source.getPassword()));

        String roles = Stream.of(source.getRole())
                .map(String::valueOf)
                .collect(Collectors.joining(",", "[\"", "\"]"));

        usuario.setRoles(roles);

        return usuario;

    }
}
