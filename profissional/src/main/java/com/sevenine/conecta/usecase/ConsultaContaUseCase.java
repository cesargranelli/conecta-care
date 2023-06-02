package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.response.ContaResponse;

public interface ConsultaContaUseCase {
    ContaResponse executar(Long profissionalId);
}
