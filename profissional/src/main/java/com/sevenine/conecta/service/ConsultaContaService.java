package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.ContaResponse;

public interface ConsultaContaService {
    ContaResponse consultar(Long profissionalId);
}
