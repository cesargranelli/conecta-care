package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.ProfissionalFiltroDadosSmsResponse;

import java.util.List;

public interface ProfissionalFiltroDadosSmsService {
    List<ProfissionalFiltroDadosSmsResponse> consultar(List<Long> idsEspecialidades, Long idEstado);
}
