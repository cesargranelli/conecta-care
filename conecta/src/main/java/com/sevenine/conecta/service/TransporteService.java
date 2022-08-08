package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.ConsultaTransporteResponse;

import java.util.List;

public interface TransporteService {
    List<ConsultaTransporteResponse> consultar();
}
