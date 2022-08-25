package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.response.tratamento.ConsultaTratamentoResponse;

public interface ConsultaTratamentoUseCase {
    ConsultaTratamentoResponse executar(Long tratamentoId);
}
