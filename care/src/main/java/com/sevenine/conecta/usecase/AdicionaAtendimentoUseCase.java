package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.request.atendimento.AdicionaAtendimentoRequest;

public interface AdicionaAtendimentoUseCase {
    void executar(AdicionaAtendimentoRequest request);
}
