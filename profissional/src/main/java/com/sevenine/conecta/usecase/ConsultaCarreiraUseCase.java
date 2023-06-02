package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.response.CarreiraResponse;

public interface ConsultaCarreiraUseCase {
    CarreiraResponse executar(Long profissionalId);
}
