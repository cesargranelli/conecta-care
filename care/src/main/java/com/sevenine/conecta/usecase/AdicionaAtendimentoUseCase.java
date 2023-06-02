package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.request.atendimento.AdicionaAtendimentoRequest;

public interface AdicionaAtendimentoUseCase {
    void executar(AdicionaAtendimentoRequest request);
}
