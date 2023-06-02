package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.EscolaridadeResponse;

public interface ConsultaEscolaridadeService {
    EscolaridadeResponse consultar(Long profissionalId);
}
