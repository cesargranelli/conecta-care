package com.sevenine.conecta.usecase.rule.impl;

import com.sevenine.conecta.controllers.data.request.atendimento.AdicionaAtendimentoRequest;
import com.sevenine.conecta.controllers.data.request.atendimento.DiaSemanaRequest;
import com.sevenine.conecta.usecase.rule.GeraRecorrenciaSemanalRule;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@Component
public class GeraRecorrenciaSemanalRuleImpl implements GeraRecorrenciaSemanalRule {

    @Override
    public List<AdicionaAtendimentoRequest> calcular(AdicionaAtendimentoRequest request) {
        List<AdicionaAtendimentoRequest> atendimentoRequestList = new ArrayList<>();
        for (DiaSemanaRequest dia : request.getRecorrencia().getSemanal().getDias()) {
            request.setData(LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.of(dia.getId().intValue()))));
            atendimentoRequestList.add(request);
        }
        return atendimentoRequestList;
    }

}
