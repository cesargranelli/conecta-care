package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.http.data.request.EsqueciMinhaSenhaRequest;
import com.sevenine.conecta.http.data.response.EsqueciMinhaSenhaResponse;
import com.sevenine.conecta.repository.data.Usuario;
import com.sevenine.conecta.service.ConsultaUsuarioService;
import com.sevenine.conecta.usecase.SolicitaAlteracaoSenhaUseCase;
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
