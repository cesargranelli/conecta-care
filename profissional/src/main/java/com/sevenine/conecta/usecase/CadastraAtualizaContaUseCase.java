package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.request.ContaRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaContaResponse;

public interface CadastraAtualizaContaUseCase {
    CadastraAtualizaContaResponse executar(ContaRequest request);
}
