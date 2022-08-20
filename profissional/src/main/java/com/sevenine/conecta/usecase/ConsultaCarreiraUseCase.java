package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.response.CarreiraResponse;

public interface ConsultaCarreiraUseCase {
    CarreiraResponse executar(Long profissionalId);
}
