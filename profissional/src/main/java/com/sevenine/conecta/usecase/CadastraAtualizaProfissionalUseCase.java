package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.request.ProfissionalRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaProfissionalResponse;

public interface CadastraAtualizaProfissionalUseCase {
    CadastraAtualizaProfissionalResponse executar(ProfissionalRequest request);
}
