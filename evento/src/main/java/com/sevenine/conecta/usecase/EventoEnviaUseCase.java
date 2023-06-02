package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.response.EnvioResponse;

public interface EventoEnviaUseCase {
    EnvioResponse executar(long idEvento);
}
