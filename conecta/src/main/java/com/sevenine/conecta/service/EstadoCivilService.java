package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.ConsultaEstadoCivilResponse;

import java.util.List;

public interface EstadoCivilService {
    List<ConsultaEstadoCivilResponse> consultar();
}
