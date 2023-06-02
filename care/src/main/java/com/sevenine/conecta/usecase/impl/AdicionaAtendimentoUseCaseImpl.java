package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.adapter.controller.data.request.atendimento.AdicionaAtendimentoRequest;
import com.sevenine.conecta.services.AdicionaAtendimentosService;
import com.sevenine.conecta.usecase.AdicionaAtendimentoUseCase;
import com.sevenine.conecta.usecase.rule.GeraRecorrenciaDiariaRule;
import com.sevenine.conecta.usecase.rule.GeraRecorrenciaSemanalRule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Component
public class AdicionaAtendimentoUseCaseImpl implements AdicionaAtendimentoUseCase {

    private final AdicionaAtendimentosService adicionaAtendimentosService;

    private final GeraRecorrenciaDiariaRule geraRecorrenciaDiariaRule;
    private final GeraRecorrenciaSemanalRule geraRecorrenciaSemanalRule;

    @Override
    public void executar(AdicionaAtendimentoRequest request) {
        if (!isNull(request.getRecorrencia())) {
            if (!isNull(request.getRecorrencia().getDiaria())) {
                adicionaAtendimentosService.adicionar(geraRecorrenciaDiariaRule.calcular(request));
            } else {
                adicionaAtendimentosService.adicionar(geraRecorrenciaSemanalRule.calcular(request));
            }
        } else {
            adicionaAtendimentosService.adicionar(Collections.singletonList(request));
        }
    }

}
