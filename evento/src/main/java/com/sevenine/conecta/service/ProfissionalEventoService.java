package com.sevenine.conecta.services;

import com.sevenine.conecta.services.data.response.ProfissionalEventoResponse;

import java.util.List;

public interface ProfissionalEventoService {
    List<ProfissionalEventoResponse> pesquisar(List<Long> idsEspecialidades, Long idEstado);
}
