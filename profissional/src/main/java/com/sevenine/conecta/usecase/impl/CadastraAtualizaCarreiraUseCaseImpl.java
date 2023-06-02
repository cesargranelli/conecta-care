package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.adapter.controller.data.request.CarreiraRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaCarreiraResponse;
import com.sevenine.conecta.services.CadastraAtualizaCarreiraService;
import com.sevenine.conecta.usecase.CadastraAtualizaCarreiraUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CadastraAtualizaCarreiraUseCaseImpl implements CadastraAtualizaCarreiraUseCase {

    private final CadastraAtualizaCarreiraService cadastraAtualizaCarreiraService;

    @Override
    public CadastraAtualizaCarreiraResponse executar(CarreiraRequest request) {
        return cadastraAtualizaCarreiraService.salvar(request);
    }

}
