package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.ComplementoResponse;

public interface ConsultaComplementoService {
    ComplementoResponse consultar(Long profissionalId);
}
