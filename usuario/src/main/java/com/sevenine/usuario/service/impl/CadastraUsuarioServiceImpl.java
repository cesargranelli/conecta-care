package com.sevenine.usuario.services.impl;

import com.sevenine.usuario.adapter.controller.data.request.CadastroUsuarioRequest;
import com.sevenine.usuario.repository.UsuarioRepository;
import com.sevenine.usuario.repository.data.Usuario;
import com.sevenine.usuario.services.CadastraUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

import static java.util.Objects.requireNonNull;

@RequiredArgsConstructor
@Service
public class CadastraUsuarioServiceImpl implements CadastraUsuarioService {

    private final UsuarioRepository repository;
    private final Converter<CadastroUsuarioRequest, Usuario> usuarioRequestConverter;

    @Override
    public Usuario cadastrar(CadastroUsuarioRequest request) throws SQLIntegrityConstraintViolationException {
        try {
            Usuario usuario = usuarioRequestConverter.convert(request);
            return repository.save(requireNonNull(usuario));
        } catch (Exception ex) {
            throw new SQLIntegrityConstraintViolationException(ex.getCause());
        }
    }

}
