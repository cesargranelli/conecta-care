package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.EnderecoResponse;

public interface ConsultaEnderecoService {
    EnderecoResponse consultar(Long profissionalId);
}
