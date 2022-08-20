package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.response.ComplementoResponse;

public interface ConsultaComplementoUseCase {
    ComplementoResponse executar(Long profissionalId);
}
