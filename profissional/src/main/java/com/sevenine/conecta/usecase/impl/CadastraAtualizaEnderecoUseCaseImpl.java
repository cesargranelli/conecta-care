package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.adapter.controller.data.request.EnderecoRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaEnderecoResponse;
import com.sevenine.conecta.services.CadastraAtualizaEnderecoService;
import com.sevenine.conecta.usecase.CadastraAtualizaEnderecoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CadastraAtualizaEnderecoUseCaseImpl implements CadastraAtualizaEnderecoUseCase {

    private final CadastraAtualizaEnderecoService service;

    @Override
    public CadastraAtualizaEnderecoResponse executar(EnderecoRequest request) {
        return service.salvar(request);
    }

}
