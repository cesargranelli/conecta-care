package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.entity.ValidacaoUsuario;
import com.sevenine.conecta.controllers.data.response.ValidationResponse;
import com.sevenine.conecta.repository.data.SequenceCadastro;
import com.sevenine.conecta.repository.data.Usuario;
import com.sevenine.conecta.services.ConsultaUsuarioService;
import com.sevenine.conecta.services.DocumentoService;
import com.sevenine.conecta.usecase.ValidaUsuarioUseCase;
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
