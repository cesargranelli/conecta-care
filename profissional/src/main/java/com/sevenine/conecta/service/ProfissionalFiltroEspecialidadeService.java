package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.ProfissionalResponse;

import java.util.List;

public interface ProfissionalFiltroEspecialidadeService {
    List<ProfissionalResponse> consultar(List<Long> idsEspecialidades);
}
