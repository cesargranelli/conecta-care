package com.sevenine.conecta.service;

import com.sevenine.conecta.service.data.response.AtendimentoProfissionalResponse;

public interface ConsultaProfissionalService {
    AtendimentoProfissionalResponse consultar(Long profissionalId);
}
