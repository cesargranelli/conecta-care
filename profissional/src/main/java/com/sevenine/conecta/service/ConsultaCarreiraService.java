package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.CarreiraResponse;

public interface ConsultaCarreiraService {
    CarreiraResponse consultar(Long profissionalId);
}
