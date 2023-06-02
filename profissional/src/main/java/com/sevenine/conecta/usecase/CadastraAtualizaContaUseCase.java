package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.request.ContaRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaContaResponse;

public interface CadastraAtualizaContaUseCase {
    CadastraAtualizaContaResponse executar(ContaRequest request);
}
