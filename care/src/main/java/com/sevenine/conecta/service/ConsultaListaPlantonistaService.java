package com.sevenine.conecta.service;

import com.sevenine.conecta.service.data.response.PlantonistaResponse;

import java.util.List;

public interface ConsultaListaPlantonistaService {
    List<PlantonistaResponse> consultar(List<Long> plantonistasIds);
}
