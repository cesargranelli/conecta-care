package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaGeneroResponse;

import java.util.List;

public interface GeneroService {
    List<ConsultaGeneroResponse> consultar();
}
