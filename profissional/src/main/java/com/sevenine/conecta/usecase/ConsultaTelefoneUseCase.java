package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.response.TelefoneResponse;

public interface ConsultaTelefoneUseCase {
    TelefoneResponse executar(Long profissionalId);
}
