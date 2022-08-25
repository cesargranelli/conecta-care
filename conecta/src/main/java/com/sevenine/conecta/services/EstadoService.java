package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.ConsultaEstadoResponse;

import java.util.List;

public interface EstadoService {
    List<ConsultaEstadoResponse> consultar();
}
