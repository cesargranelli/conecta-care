package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.response.EnvioResponse;

public interface EventoEnviaUseCase {
    EnvioResponse executar(long idEvento);
}
