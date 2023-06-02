package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.ProfissionalCpfResponse;

import java.util.List;

public interface BuscaProfissionalPorNomeService {

    List<ProfissionalCpfResponse> consultar(String nome);

}
