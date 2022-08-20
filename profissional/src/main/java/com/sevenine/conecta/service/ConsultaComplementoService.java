package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.ComplementoResponse;

public interface ConsultaComplementoService {
    ComplementoResponse consultar(Long profissionalId);
}
