package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.response.ListaProfissionalResponse;

import java.util.List;

public interface ListaProfissionalUseCase {
    List<ListaProfissionalResponse> executar(List<Long> profissionaisIds);
}
