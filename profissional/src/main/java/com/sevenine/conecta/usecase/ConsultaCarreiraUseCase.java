package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.response.CarreiraResponse;

public interface ConsultaCarreiraUseCase {
    CarreiraResponse executar(Long profissionalId);
}
