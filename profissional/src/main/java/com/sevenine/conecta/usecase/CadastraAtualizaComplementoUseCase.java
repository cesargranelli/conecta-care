package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.request.ComplementoRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaComplementoResponse;

public interface CadastraAtualizaComplementoUseCase {
    CadastraAtualizaComplementoResponse executar(ComplementoRequest request);
}
