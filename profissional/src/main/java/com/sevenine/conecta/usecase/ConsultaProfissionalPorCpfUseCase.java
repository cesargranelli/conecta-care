package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.response.ProfissionalResponse;

public interface ConsultaProfissionalPorCpfUseCase {
    ProfissionalResponse executar(String numeroCpf);
}
