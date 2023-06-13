package com.sevenine.usuario.usecase;

import com.sevenine.usuario.adapter.controller.data.request.EsqueciMinhaSenhaRequest;
import com.sevenine.usuario.adapter.controller.data.response.EsqueciMinhaSenhaResponse;

public interface SolicitaAlteracaoSenhaUseCase {
    EsqueciMinhaSenhaResponse executar(EsqueciMinhaSenhaRequest request);
}
