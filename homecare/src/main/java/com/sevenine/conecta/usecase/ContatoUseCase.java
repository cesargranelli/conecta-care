package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.request.ContatoRequest;
import com.sevenine.conecta.controllers.data.response.ContatoCadastroResponse;
import com.sevenine.conecta.controllers.data.response.ContatoResponse;
import com.sevenine.conecta.services.AtivaUsuarioService;
import com.sevenine.conecta.services.ContatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContatoUseCase {

    private final ContatoService contatoService;

    private final AtivaUsuarioService ativaUsuarioService;

    public ContatoCadastroResponse cadastrar(ContatoRequest request) {
        ContatoCadastroResponse contatoCadastroResponse = contatoService.cadastrar(request);
        ativaUsuarioService.ativar(request.getIdHomeCare());
        return contatoCadastroResponse;
    }

    public void alterar(ContatoRequest request) {
        ativaUsuarioService.ativar(request.getIdHomeCare());
    }

    public ContatoResponse consultar(Long idHomeCare) {
        return contatoService.consultar(idHomeCare);
    }

}
