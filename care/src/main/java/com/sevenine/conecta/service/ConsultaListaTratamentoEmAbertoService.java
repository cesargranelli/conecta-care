package com.sevenine.conecta.services;

import com.sevenine.conecta.services.data.response.ConsultaListaTratamentoResponse;

import java.util.List;

public interface ConsultaListaTratamentoEmAbertoService {
    List<ConsultaListaTratamentoResponse> consultar(Long homeCareId);
}
