package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.ProfissionalResponse;

import java.util.List;

public interface ProfissionalFiltroEspecialidadeService {
    List<ProfissionalResponse> consultar(List<Long> idsEspecialidades);
}
