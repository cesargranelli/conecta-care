package com.sevenine.usuario.usecase.impl;

import com.sevenine.usuario.entity.ValidacaoUsuario;
import com.sevenine.usuario.adapter.controller.data.response.ValidationResponse;
import com.sevenine.usuario.repository.data.SequenceCadastro;
import com.sevenine.usuario.repository.data.Usuario;
import com.sevenine.usuario.services.ConsultaUsuarioService;
import com.sevenine.usuario.services.DocumentoService;
import com.sevenine.usuario.usecase.ValidaUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ValidaUsuarioUseCaseImpl implements ValidaUsuarioUseCase {

    private final ConsultaUsuarioService consultaUsuarioService;
    private final DocumentoService documentoService;

    @Override
    public ValidationResponse executar(ValidacaoUsuario validacaoUsuario) {
        Usuario usuario = consultaUsuarioService.buscarUsuario(validacaoUsuario.getUsername());
        List<SequenceCadastro> sequenceCadastros = usuario.getDocumentoUsuario();
        Optional<SequenceCadastro> optional =
                sequenceCadastros.stream()
                        .filter(sequenceCadastro -> sequenceCadastro.getModulo().name().equals(validacaoUsuario.getModule()))
                        .findAny();
        if (!optional.isPresent()) {
            return ValidationResponse.builder().build();
        }
        return ValidationResponse.builder()
                .id(optional.get().getId())
                .email(validacaoUsuario.getUsername())
                .role("ROLE_" + validacaoUsuario.getModule())
                .build();
    }

}
