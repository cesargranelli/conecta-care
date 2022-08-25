package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.response.ContaResponse;

public interface ConsultaContaUseCase {
    ContaResponse executar(Long profissionalId);
}
