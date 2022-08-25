package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.request.atendimento.AdicionaAtendimentoSituacaoRequest;
import com.sevenine.conecta.repository.data.Atendimento;

public interface AdicionaAtendimentoSituacaoService {
    void adicionar(AdicionaAtendimentoSituacaoRequest request, Atendimento atendimento);
}
