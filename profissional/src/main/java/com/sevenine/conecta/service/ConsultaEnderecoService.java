package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.EnderecoResponse;

public interface ConsultaEnderecoService {
    EnderecoResponse consultar(Long profissionalId);
}
