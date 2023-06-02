package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.response.ComplementoResponse;

public interface ConsultaComplementoUseCase {
    ComplementoResponse executar(Long profissionalId);
}
