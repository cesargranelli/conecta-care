package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.request.ProfissionalRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaProfissionalResponse;

public interface CadastraAtualizaProfissionalService {
    CadastraAtualizaProfissionalResponse salvar(ProfissionalRequest request);
}
