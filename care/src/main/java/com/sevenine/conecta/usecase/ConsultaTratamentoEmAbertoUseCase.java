package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.response.tratamento.ConsultaTratamentoResponse;

public interface ConsultaTratamentoEmAbertoUseCase {
    ConsultaTratamentoResponse executar(Long pacienteId, Long homeCareId);
}
