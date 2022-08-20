package com.connecta.evento.service;

import com.connecta.evento.service.data.response.ProfissionalEventoResponse;

import java.util.List;

public interface ProfissionalEventoService {
    List<ProfissionalEventoResponse> pesquisar(List<Long> idsEspecialidades, Long idEstado);
}
