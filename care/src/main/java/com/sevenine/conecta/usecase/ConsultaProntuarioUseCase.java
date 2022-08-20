package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.response.tratamento.ProntuarioResponse;

public interface ConsultaProntuarioUseCase {
    ProntuarioResponse executar(Long pacienteId, Long homeCareId);
}
