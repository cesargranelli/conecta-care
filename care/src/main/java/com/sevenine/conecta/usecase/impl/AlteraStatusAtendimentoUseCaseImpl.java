package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.service.AlteraStatusAtendimentoService;
import com.sevenine.conecta.usecase.AlteraStatusAtendimentoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlteraStatusAtendimentoUseCaseImpl implements AlteraStatusAtendimentoUseCase {

    private final AlteraStatusAtendimentoService alteraStatusAtendimentoService;

    @Override
    public void executar(String status, Long atendimentoId) {
        alteraStatusAtendimentoService.alterar(status, atendimentoId);
    }

}
