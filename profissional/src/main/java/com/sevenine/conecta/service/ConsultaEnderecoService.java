package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.EnderecoResponse;

public interface ConsultaEnderecoService {
    EnderecoResponse consultar(Long profissionalId);
}
