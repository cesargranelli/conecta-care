package com.sevenine.conecta.services;

import com.sevenine.conecta.services.data.response.AtendimentoProfissionalResponse;

public interface ConsultaProfissionalService {
    AtendimentoProfissionalResponse consultar(Long profissionalId);
}
