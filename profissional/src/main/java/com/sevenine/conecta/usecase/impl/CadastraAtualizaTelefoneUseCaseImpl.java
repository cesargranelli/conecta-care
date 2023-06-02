package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.adapter.controller.data.request.TelefoneRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaTelefoneResponse;
import com.sevenine.conecta.services.CadastraAtualizaTelefoneService;
import com.sevenine.conecta.usecase.CadastraAtualizaTelefoneUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CadastraAtualizaTelefoneUseCaseImpl implements CadastraAtualizaTelefoneUseCase {

    private final CadastraAtualizaTelefoneService service;

    @Override
    public CadastraAtualizaTelefoneResponse executar(TelefoneRequest request) {
        return service.salvar(request);
    }
}
