package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.ConsultaTransporteResponse;

import java.util.List;

public interface TransporteService {
    List<ConsultaTransporteResponse> consultar();
}
