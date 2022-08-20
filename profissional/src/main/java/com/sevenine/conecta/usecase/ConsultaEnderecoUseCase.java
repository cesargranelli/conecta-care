package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.response.EnderecoResponse;

public interface ConsultaEnderecoUseCase {
    EnderecoResponse executar(Long profissionalId);
}
