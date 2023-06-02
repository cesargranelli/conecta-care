package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.response.tratamento.ProntuarioResponse;

public interface ConsultaProntuarioUseCase {
    ProntuarioResponse executar(Long pacienteId, Long homeCareId);
}
