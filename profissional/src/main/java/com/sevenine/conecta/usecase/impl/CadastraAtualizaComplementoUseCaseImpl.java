package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controllers.data.request.ComplementoRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaComplementoResponse;
import com.sevenine.conecta.services.CadastraAtualizaComplementoService;
import com.sevenine.conecta.usecase.CadastraAtualizaComplementoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CadastraAtualizaComplementoUseCaseImpl implements CadastraAtualizaComplementoUseCase {

    private final CadastraAtualizaComplementoService service;

    @Override
    public CadastraAtualizaComplementoResponse executar(ComplementoRequest request) {
        return service.salvar(request);
    }

}
