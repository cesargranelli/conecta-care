package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.TelefoneResponse;

public interface ConsultaTelefoneService {
    TelefoneResponse consultar(Long profissionalId);
}
