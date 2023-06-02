package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.response.ProfissionalResponse;

public interface ConsultaProfissionalPorCpfUseCase {
    ProfissionalResponse executar(String numeroCpf);
}
