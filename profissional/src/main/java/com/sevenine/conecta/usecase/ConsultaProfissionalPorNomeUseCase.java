package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.response.ProfissionalCpfResponse;

import java.util.List;

public interface ConsultaProfissionalPorNomeUseCase {
    List<ProfissionalCpfResponse> executar(String nome);
}
