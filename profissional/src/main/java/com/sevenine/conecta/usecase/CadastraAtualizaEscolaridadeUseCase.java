package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.request.EscolaridadeRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaEscolaridadeResponse;

public interface CadastraAtualizaEscolaridadeUseCase {
    CadastraAtualizaEscolaridadeResponse executar(EscolaridadeRequest request);
}
