package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.request.EsqueciMinhaSenhaRequest;
import com.sevenine.conecta.adapter.controller.data.response.EsqueciMinhaSenhaResponse;

public interface SolicitaAlteracaoSenhaUseCase {
    EsqueciMinhaSenhaResponse executar(EsqueciMinhaSenhaRequest request);
}
