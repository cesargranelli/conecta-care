package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.request.ContaRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaContaResponse;

public interface CadastraAtualizaContaUseCase {
    CadastraAtualizaContaResponse executar(ContaRequest request);
}
