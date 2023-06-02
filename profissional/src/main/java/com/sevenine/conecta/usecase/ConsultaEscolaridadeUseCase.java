package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.response.EscolaridadeResponse;

public interface ConsultaEscolaridadeUseCase {
    EscolaridadeResponse executar(Long profissionalId);
}
