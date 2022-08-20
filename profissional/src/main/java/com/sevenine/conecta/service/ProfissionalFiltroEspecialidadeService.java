package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.ProfissionalResponse;

import java.util.List;

public interface ProfissionalFiltroEspecialidadeService {
    List<ProfissionalResponse> consultar(List<Long> idsEspecialidades);
}
