package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controller.data.request.CarreiraRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaCarreiraResponse;
import com.sevenine.conecta.service.CadastraAtualizaCarreiraService;
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
