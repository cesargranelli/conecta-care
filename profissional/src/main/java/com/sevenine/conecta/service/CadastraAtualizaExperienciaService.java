package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.request.ExperienciaRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaExperienciaResponse;

import java.util.List;

public interface CadastraAtualizaExperienciaService {
    CadastraAtualizaExperienciaResponse salvar(List<ExperienciaRequest> request);
}
