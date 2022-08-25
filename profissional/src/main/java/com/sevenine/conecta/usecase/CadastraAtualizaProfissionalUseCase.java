package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.request.ProfissionalRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaProfissionalResponse;

public interface CadastraAtualizaProfissionalUseCase {
    CadastraAtualizaProfissionalResponse executar(ProfissionalRequest request);
}
