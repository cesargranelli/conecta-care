package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controllers.data.request.EscolaridadeRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaEscolaridadeResponse;
import com.sevenine.conecta.services.CadastraAtualizaEscolaridadeService;
import com.sevenine.conecta.usecase.CadastraAtualizaEscolaridadeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CadastraAtualizaEscolaridadeUseCaseImpl implements CadastraAtualizaEscolaridadeUseCase {

    private final CadastraAtualizaEscolaridadeService service;

    @Override
    public CadastraAtualizaEscolaridadeResponse executar(EscolaridadeRequest request) {
        return service.salvar(request);
    }

}
