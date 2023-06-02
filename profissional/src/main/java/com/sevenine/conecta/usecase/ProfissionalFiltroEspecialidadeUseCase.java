package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.response.ProfissionalResponse;

import java.util.List;

public interface ProfissionalFiltroEspecialidadeUseCase {
    List<ProfissionalResponse> executar(List<Long> idsEspecialidades);
}
