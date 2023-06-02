package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.request.atendimento.AdicionaAtendimentoSituacaoRequest;
import com.sevenine.conecta.repository.data.Atendimento;

public interface AdicionaAtendimentoSituacaoService {
    void adicionar(AdicionaAtendimentoSituacaoRequest request, Atendimento atendimento);
}
