package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.TelefoneResponse;

public interface ConsultaTelefoneService {
    TelefoneResponse consultar(Long profissionalId);
}
