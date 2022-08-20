package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.EscolaridadeResponse;

public interface ConsultaEscolaridadeService {
    EscolaridadeResponse consultar(Long profissionalId);
}
