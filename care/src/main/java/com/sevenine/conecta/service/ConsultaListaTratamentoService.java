package com.sevenine.conecta.service;

import com.sevenine.conecta.service.data.response.TratamentoResponse;

import java.util.List;

public interface ConsultaListaTratamentoService {
    List<TratamentoResponse> consultar(Long pacienteId, Long homeCareId);
}
