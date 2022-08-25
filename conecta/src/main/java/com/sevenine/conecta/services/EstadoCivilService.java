package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.ConsultaEstadoCivilResponse;

import java.util.List;

public interface EstadoCivilService {
    List<ConsultaEstadoCivilResponse> consultar();
}
