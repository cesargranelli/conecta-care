package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.ProfissionalCpfResponse;

import java.util.List;

public interface BuscaProfissionalPorNomeService {

    List<ProfissionalCpfResponse> consultar(String nome);

}
