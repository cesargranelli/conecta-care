package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.adapter.controller.data.request.atendimento.BaixaRequest;
import com.sevenine.conecta.services.BaixaAtendimentoService;
import com.sevenine.conecta.usecase.BaixaAtendimentoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BaixaAtendimentoUseCaseImpl implements BaixaAtendimentoUseCase {

    private final BaixaAtendimentoService baixaAtendimentoService;

    @Override
    public void executar(BaixaRequest request) {
        baixaAtendimentoService.baixar(request);
    }

}
