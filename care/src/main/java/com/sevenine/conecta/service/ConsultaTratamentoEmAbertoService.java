package com.sevenine.conecta.services;

import com.sevenine.conecta.services.data.response.TratamentoResponse;

public interface ConsultaTratamentoEmAbertoService {
    TratamentoResponse consultar(Long pacienteId, Long homeCareId);
}
