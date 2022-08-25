package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.TelefoneResponse;

public interface ConsultaTelefoneService {
    TelefoneResponse consultar(Long profissionalId);
}
