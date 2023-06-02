package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.ContaResponse;

public interface ConsultaContaService {
    ContaResponse consultar(Long profissionalId);
}
