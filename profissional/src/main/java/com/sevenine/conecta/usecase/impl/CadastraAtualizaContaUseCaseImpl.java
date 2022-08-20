package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controller.data.request.ContaRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaContaResponse;
import com.sevenine.conecta.service.AtivaUsuarioService;
import com.sevenine.conecta.service.CadastraAtualizaContaService;
import com.sevenine.conecta.usecase.CadastraAtualizaContaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CadastraAtualizaContaUseCaseImpl implements CadastraAtualizaContaUseCase {

    private final CadastraAtualizaContaService cadastraAtualizaContaService;

    private final AtivaUsuarioService ativaUsuarioService;

    @Override
    public CadastraAtualizaContaResponse executar(ContaRequest request) {
        CadastraAtualizaContaResponse cadastraAtualizaContaResponse = cadastraAtualizaContaService.salvar(request);
        ativaUsuarioService.ativar(request.getProprietarioId());
        return cadastraAtualizaContaResponse;
    }

}
