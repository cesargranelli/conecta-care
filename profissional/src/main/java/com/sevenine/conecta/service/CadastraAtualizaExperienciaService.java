package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.request.ExperienciaRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaExperienciaResponse;

import java.util.List;

public interface CadastraAtualizaExperienciaService {
    CadastraAtualizaExperienciaResponse salvar(List<ExperienciaRequest> request);
}
