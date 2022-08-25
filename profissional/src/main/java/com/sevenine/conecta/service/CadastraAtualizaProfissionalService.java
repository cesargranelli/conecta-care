package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.request.ProfissionalRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaProfissionalResponse;

public interface CadastraAtualizaProfissionalService {
    CadastraAtualizaProfissionalResponse salvar(ProfissionalRequest request);
}
