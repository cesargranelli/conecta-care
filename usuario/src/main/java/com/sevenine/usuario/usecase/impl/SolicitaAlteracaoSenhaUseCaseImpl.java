package com.sevenine.usuario.usecase.impl;

import com.sevenine.usuario.adapter.controller.data.request.EsqueciMinhaSenhaRequest;
import com.sevenine.usuario.adapter.controller.data.response.EsqueciMinhaSenhaResponse;
import com.sevenine.usuario.repository.data.Usuario;
import com.sevenine.usuario.services.ConsultaUsuarioService;
import com.sevenine.usuario.usecase.SolicitaAlteracaoSenhaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Component
public class SolicitaAlteracaoSenhaUseCaseImpl implements SolicitaAlteracaoSenhaUseCase {

    private final ConsultaUsuarioService usuarioService;

    @Override
    public EsqueciMinhaSenhaResponse executar(EsqueciMinhaSenhaRequest request) {
        Usuario usuario = usuarioService.buscarUsuario(request.getEmail());

        EsqueciMinhaSenhaResponse esqueciMinhaSenhaResponse = new EsqueciMinhaSenhaResponse();
        if (isNull(usuario)) {
            esqueciMinhaSenhaResponse.setMessage("Usuário não possui cadastro no sistema Connecta Care!");
        }// else if () {

        //}

        return esqueciMinhaSenhaResponse;
    }

}
