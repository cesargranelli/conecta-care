package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.response.EnderecoResponse;

public interface ConsultaEnderecoUseCase {
    EnderecoResponse executar(Long profissionalId);
}
