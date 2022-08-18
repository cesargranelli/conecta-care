package com.sevenine.conecta.usecase;

import com.sevenine.conecta.http.data.request.EsqueciMinhaSenhaRequest;
import com.sevenine.conecta.http.data.response.EsqueciMinhaSenhaResponse;

public interface SolicitaAlteracaoSenhaUseCase {
    EsqueciMinhaSenhaResponse executar(EsqueciMinhaSenhaRequest request);
}
