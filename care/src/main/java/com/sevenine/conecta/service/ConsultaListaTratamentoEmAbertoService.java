package com.sevenine.conecta.service;

import com.sevenine.conecta.service.data.response.ConsultaListaTratamentoResponse;

import java.util.List;

public interface ConsultaListaTratamentoEmAbertoService {
    List<ConsultaListaTratamentoResponse> consultar(Long homeCareId);
}
