package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.ProfissionalFiltroDadosSmsResponse;

import java.util.List;

public interface ProfissionalFiltroDadosSmsService {
    List<ProfissionalFiltroDadosSmsResponse> consultar(List<Long> idsEspecialidades, Long idEstado);
}
