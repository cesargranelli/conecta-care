package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.response.ProfissionalResponse;

public interface ConsultaProfissionalPorCpfUseCase {
    ProfissionalResponse executar(String numeroCpf);
}
