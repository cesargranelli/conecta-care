package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.response.ProfissionalResponse;

import java.util.List;

public interface ProfissionalFiltroEspecialidadeUseCase {
    List<ProfissionalResponse> executar(List<Long> idsEspecialidades);
}
