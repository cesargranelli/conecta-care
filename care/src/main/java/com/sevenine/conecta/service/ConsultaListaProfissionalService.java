package com.sevenine.conecta.service;

import com.sevenine.conecta.service.data.response.AtendimentoProfissionalResponse;

import java.util.List;

public interface ConsultaListaProfissionalService {
    List<AtendimentoProfissionalResponse> consultar(List<Long> profissionaisIds);
}
