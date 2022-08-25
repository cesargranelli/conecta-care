package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.ContaResponse;

public interface ConsultaContaService {
    ContaResponse consultar(Long profissionalId);
}
