package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.request.ComplementoRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaComplementoResponse;

public interface CadastraAtualizaComplementoUseCase {
    CadastraAtualizaComplementoResponse executar(ComplementoRequest request);
}
