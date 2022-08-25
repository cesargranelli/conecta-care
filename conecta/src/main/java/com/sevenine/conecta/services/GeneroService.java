package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.ConsultaGeneroResponse;

import java.util.List;

public interface GeneroService {
    List<ConsultaGeneroResponse> consultar();
}
