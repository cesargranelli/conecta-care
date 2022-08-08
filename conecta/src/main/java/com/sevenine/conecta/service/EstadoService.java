package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.ConsultaEstadoResponse;

import java.util.List;

public interface EstadoService {
    List<ConsultaEstadoResponse> consultar();
}
