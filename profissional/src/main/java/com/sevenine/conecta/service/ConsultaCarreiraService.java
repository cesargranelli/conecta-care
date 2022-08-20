package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.CarreiraResponse;

public interface ConsultaCarreiraService {
    CarreiraResponse consultar(Long profissionalId);
}
