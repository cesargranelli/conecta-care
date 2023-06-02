package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.request.ExperienciaRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaExperienciaResponse;

import java.util.List;

public interface CadastraAtualizaExperienciaUseCase {
    CadastraAtualizaExperienciaResponse executar(List<ExperienciaRequest> request);
}
