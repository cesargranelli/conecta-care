package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaTransporteResponse;

import java.util.List;

public interface TransporteService {
    List<ConsultaTransporteResponse> consultar();
}
