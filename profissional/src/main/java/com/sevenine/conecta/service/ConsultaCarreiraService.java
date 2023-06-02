package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.CarreiraResponse;

public interface ConsultaCarreiraService {
    CarreiraResponse consultar(Long profissionalId);
}
