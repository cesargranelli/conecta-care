package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.request.ContatoRequest;
import com.sevenine.conecta.adapter.controller.data.response.ContatoCadastroResponse;
import com.sevenine.conecta.adapter.controller.data.response.ContatoResponse;
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
        ativaUsuarioService.ativar(request.getIdPlanoSaude());
        return contatoCadastroResponse;
    }

    public void alterar(ContatoRequest request) {
        contatoService.alterar(request);
    }

    public ContatoResponse consultar(Long idPlanoSaude) {
        return contatoService.consultar(idPlanoSaude);
    }

}
