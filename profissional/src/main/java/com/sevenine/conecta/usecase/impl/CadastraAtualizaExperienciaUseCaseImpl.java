package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.adapter.controller.data.request.ExperienciaRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaExperienciaResponse;
import com.sevenine.conecta.services.CadastraAtualizaExperienciaService;
import com.sevenine.conecta.usecase.CadastraAtualizaExperienciaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CadastraAtualizaExperienciaUseCaseImpl implements CadastraAtualizaExperienciaUseCase {

    private final CadastraAtualizaExperienciaService service;

    @Override
    public CadastraAtualizaExperienciaResponse executar(List<ExperienciaRequest> request) {
        return service.salvar(request);
    }

}
