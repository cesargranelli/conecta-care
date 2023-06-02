package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.request.tratamento.EncerraTratamentoRequest;

public interface EncerraTratamentoUseCase {
    void executar(EncerraTratamentoRequest request);
}
