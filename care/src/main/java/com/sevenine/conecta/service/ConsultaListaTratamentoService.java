package com.sevenine.conecta.services;

import com.sevenine.conecta.services.data.response.TratamentoResponse;

import java.util.List;

public interface ConsultaListaTratamentoService {
    List<TratamentoResponse> consultar(Long pacienteId, Long homeCareId);
}
