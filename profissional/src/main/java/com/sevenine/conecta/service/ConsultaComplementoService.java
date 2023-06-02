package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.ComplementoResponse;

public interface ConsultaComplementoService {
    ComplementoResponse consultar(Long profissionalId);
}
