package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controller.data.request.EscolaridadeRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaEscolaridadeResponse;
import com.sevenine.conecta.service.CadastraAtualizaEscolaridadeService;
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
