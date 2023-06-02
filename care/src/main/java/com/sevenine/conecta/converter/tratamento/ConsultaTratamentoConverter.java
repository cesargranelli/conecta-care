package com.sevenine.conecta.converter.tratamento;

import com.sevenine.conecta.adapter.controller.data.response.tratamento.ConsultaTratamentoResponse;
import com.sevenine.conecta.services.data.response.TratamentoResponse;

public interface ConsultaTratamentoConverter {
    ConsultaTratamentoResponse fromTratamentoResponseToConsultaTratamentoResponse(TratamentoResponse tratamentoResponse);
}
