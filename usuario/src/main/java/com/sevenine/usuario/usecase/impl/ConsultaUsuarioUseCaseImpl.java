package com.sevenine.usuario.usecase.impl;

import com.sevenine.usuario.entity.ConsultaUsuario;
import com.sevenine.usuario.adapter.controller.data.response.ConsultaUsuarioResponse;
import com.sevenine.usuario.repository.data.SequenceCadastro;
import com.sevenine.usuario.repository.data.Usuario;
import com.sevenine.usuario.services.ConsultaUsuarioService;
import com.sevenine.usuario.services.DocumentoService;
import com.sevenine.usuario.usecase.ConsultaUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ConsultaUsuarioUseCaseImpl implements ConsultaUsuarioUseCase {

    private final ConsultaUsuarioService consultaUsuarioService;
    private final DocumentoService documentoService;

    @Override
    public ConsultaUsuarioResponse executar(ConsultaUsuario consultaUsuario) {
        Usuario usuario = consultaUsuarioService.buscarUsuario(consultaUsuario.getUsername());
        List<SequenceCadastro> sequenceCadastros = usuario.getDocumentoUsuario();
        Optional<SequenceCadastro> optional =
                sequenceCadastros.stream()
                        .filter(sequenceCadastro -> sequenceCadastro.getModulo().name().equals(consultaUsuario.getModule()))
                        .findAny();
        if (!optional.isPresent()) {
            return ConsultaUsuarioResponse.builder().build();
        }
        SequenceCadastro sequenceCadastro = optional.get();
        ConsultaUsuarioResponse consultaUsuarioResponse = documentoService.consulta(sequenceCadastro.getId());
        consultaUsuarioResponse.setEmail(consultaUsuario.getUsername());
        consultaUsuarioResponse.setRole("ROLE_" + consultaUsuario.getModule());
        return consultaUsuarioResponse;
    }

}
