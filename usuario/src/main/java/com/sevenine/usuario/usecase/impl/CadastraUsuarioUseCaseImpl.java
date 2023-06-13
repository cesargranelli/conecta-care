package com.sevenine.usuario.usecase.impl;

import com.sevenine.usuario.adapter.controller.data.request.CadastroUsuarioRequest;
import com.sevenine.usuario.repository.data.Usuario;
import com.sevenine.usuario.services.*;
import com.sevenine.usuario.usecase.CadastraUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.stream.Collectors;

import static com.sevenine.usuario.utils.converter.RoleConverter.rolesStringToRolesList;
import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Component
public class CadastraUsuarioUseCaseImpl implements CadastraUsuarioUseCase {

    private final ConsultaUsuarioService consultaUsuarioService;
    private final CadastraUsuarioService cadastraUsuarioService;
    private final AtualizaUsuarioService atualizaUsuarioService;
    private final DocumentoUsuarioService documentoUsuarioService;
    private final GeneratedTokenService generatedTokenService;

    @Override
    public String executar(CadastroUsuarioRequest request) throws SQLException {
        Usuario usuario = consultaUsuarioService.buscarUsuario(request.getEmail());
        try {
            if (isNull(usuario)) {
                usuario = cadastraUsuarioService.cadastrar(request);
            } else {
                usuario = atualizaUsuarioService.atualizar(usuario, request);
            }
            documentoUsuarioService.associar(request.getSequence(), usuario.getId());
        } catch (SQLIntegrityConstraintViolationException ex) {
            throw new SQLException(ex.getCause());
        }
        return generatedTokenService.retrieveToken(request.getEmail(), rolesStringToRolesList(request.getRole()).stream().map(String::valueOf).collect(Collectors.toList()), request.getRole().replace("ROLE_", ""));
    }

}
