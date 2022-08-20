package com.sevenine.conecta.converter.tratamento;

import com.sevenine.conecta.controller.data.response.tratamento.ConsultaTratamentoResponse;
import com.sevenine.conecta.service.data.response.TratamentoResponse;

public interface ConsultaTratamentoConverter {
    ConsultaTratamentoResponse fromTratamentoResponseToConsultaTratamentoResponse(TratamentoResponse tratamentoResponse);
}
