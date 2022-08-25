package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.request.EsqueciMinhaSenhaRequest;
import com.sevenine.conecta.controllers.data.response.EsqueciMinhaSenhaResponse;

public interface SolicitaAlteracaoSenhaUseCase {
    EsqueciMinhaSenhaResponse executar(EsqueciMinhaSenhaRequest request);
}
