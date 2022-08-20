package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.response.TelefoneResponse;

public interface ConsultaTelefoneUseCase {
    TelefoneResponse executar(Long profissionalId);
}
