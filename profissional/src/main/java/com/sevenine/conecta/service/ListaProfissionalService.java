package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.ListaProfissionalResponse;

import java.util.List;

public interface ListaProfissionalService {
    List<ListaProfissionalResponse> listar(List<Long> profissionaisIds);
}
