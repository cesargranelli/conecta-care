package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.EscolaridadeResponse;

public interface ConsultaEscolaridadeService {
    EscolaridadeResponse consultar(Long profissionalId);
}
