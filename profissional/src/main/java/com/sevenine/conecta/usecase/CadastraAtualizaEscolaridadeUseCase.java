package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.request.EscolaridadeRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaEscolaridadeResponse;

public interface CadastraAtualizaEscolaridadeUseCase {
    CadastraAtualizaEscolaridadeResponse executar(EscolaridadeRequest request);
}
