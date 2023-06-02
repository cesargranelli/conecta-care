package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.response.ProfissionalFiltroDadosSmsResponse;

import java.util.List;

public interface ProfissionalFiltroDadosSmsUseCase {
    List<ProfissionalFiltroDadosSmsResponse> executar(List<Long> idsEspecialidades, Long idEstado);
}
