package com.sevenine.conecta.service;

import com.sevenine.conecta.service.data.response.TratamentoResponse;

public interface ConsultaTratamentoEmAbertoService {
    TratamentoResponse consultar(Long pacienteId, Long homeCareId);
}
