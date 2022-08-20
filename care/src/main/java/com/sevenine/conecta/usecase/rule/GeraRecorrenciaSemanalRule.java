package com.sevenine.conecta.usecase.rule;

import com.sevenine.conecta.controller.data.request.atendimento.AdicionaAtendimentoRequest;

import java.util.List;

public interface GeraRecorrenciaSemanalRule {
    List<AdicionaAtendimentoRequest> calcular(AdicionaAtendimentoRequest request);
}
