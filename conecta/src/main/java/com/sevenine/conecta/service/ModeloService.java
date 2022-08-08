package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.ConsultaModeloResponse;

import java.util.List;

public interface ModeloService {
    List<ConsultaModeloResponse> consultar();
}
