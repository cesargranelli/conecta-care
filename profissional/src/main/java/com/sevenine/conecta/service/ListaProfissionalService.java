package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.ListaProfissionalResponse;

import java.util.List;

public interface ListaProfissionalService {
    List<ListaProfissionalResponse> listar(List<Long> profissionaisIds);
}
