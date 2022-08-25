package com.sevenine.conecta.services;

import com.sevenine.conecta.services.data.response.AtendimentoProfissionalResponse;

import java.util.List;

public interface ConsultaListaProfissionalService {
    List<AtendimentoProfissionalResponse> consultar(List<Long> profissionaisIds);
}
