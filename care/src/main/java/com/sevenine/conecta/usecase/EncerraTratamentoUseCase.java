package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.request.tratamento.EncerraTratamentoRequest;

public interface EncerraTratamentoUseCase {
    void executar(EncerraTratamentoRequest request);
}
