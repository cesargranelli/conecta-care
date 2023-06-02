package com.sevenine.conecta.usecase.rule.impl;

import com.sevenine.conecta.adapter.controller.data.request.atendimento.AdicionaAtendimentoRequest;
import com.sevenine.conecta.usecase.rule.GeraRecorrenciaDiariaRule;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeraRecorrenciaDiariaRuleImpl implements GeraRecorrenciaDiariaRule {

    @Override
    public List<AdicionaAtendimentoRequest> calcular(AdicionaAtendimentoRequest request) {
        List<AdicionaAtendimentoRequest> atendimentoRequestList = new ArrayList<>();
        for (int i = 0; i < request.getRecorrencia().getDiaria().getQuantidade(); i++) {
            request.setData(request.getData().plusDays(i));
            atendimentoRequestList.add(request);
        }
        return atendimentoRequestList;
    }

}
