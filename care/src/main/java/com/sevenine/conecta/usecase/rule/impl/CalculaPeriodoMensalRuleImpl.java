package com.sevenine.conecta.usecase.rule.impl;

import com.sevenine.conecta.usecase.rule.CalculaPeriodoMensalRule;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;

@Component
public class CalculaPeriodoMensalRuleImpl implements CalculaPeriodoMensalRule {

    @Override
    public Map<String, LocalDate> executar(LocalDate dataConsulta) {
        if (isEmpty(dataConsulta)) dataConsulta = LocalDate.now();
        HashMap<String, LocalDate> periodoConsultaMap = new HashMap<>();
        periodoConsultaMap.put("dataInicio", dataConsulta.withDayOfMonth(1));
        periodoConsultaMap.put("dataFim", dataConsulta.plusMonths(1).withDayOfMonth(1).minusDays(1));
        return periodoConsultaMap;
    }

}
