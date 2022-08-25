package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.response.ComplementoResponse;

public interface ConsultaComplementoUseCase {
    ComplementoResponse executar(Long profissionalId);
}
