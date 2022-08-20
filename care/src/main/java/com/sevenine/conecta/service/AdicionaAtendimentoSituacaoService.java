package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.request.atendimento.AdicionaAtendimentoSituacaoRequest;
import com.sevenine.conecta.repository.data.Atendimento;

public interface AdicionaAtendimentoSituacaoService {
    void adicionar(AdicionaAtendimentoSituacaoRequest request, Atendimento atendimento);
}
