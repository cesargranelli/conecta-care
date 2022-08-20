package com.connecta.evento.usecase;

import com.connecta.evento.controller.data.response.EnvioResponse;

public interface EventoEnviaUseCase {
    EnvioResponse executar(long idEvento);
}
