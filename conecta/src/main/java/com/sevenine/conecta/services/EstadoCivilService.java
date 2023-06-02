package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaEstadoCivilResponse;

import java.util.List;

public interface EstadoCivilService {
    List<ConsultaEstadoCivilResponse> consultar();
}
