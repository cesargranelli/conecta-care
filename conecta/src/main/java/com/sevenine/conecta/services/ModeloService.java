package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.ConsultaModeloResponse;

import java.util.List;

public interface ModeloService {
    List<ConsultaModeloResponse> consultar();
}
