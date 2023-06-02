package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaCategoriaCnhResponse;

import java.util.List;

public interface CategoriaCnhService {
    List<ConsultaCategoriaCnhResponse> consultar();
}
