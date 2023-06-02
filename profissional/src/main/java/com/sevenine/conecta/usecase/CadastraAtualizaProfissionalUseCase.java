package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.request.ProfissionalRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaProfissionalResponse;

public interface CadastraAtualizaProfissionalUseCase {
    CadastraAtualizaProfissionalResponse executar(ProfissionalRequest request);
}
