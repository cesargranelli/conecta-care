package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.request.ProfissionalRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaProfissionalResponse;

public interface CadastraAtualizaProfissionalService {
    CadastraAtualizaProfissionalResponse salvar(ProfissionalRequest request);
}
